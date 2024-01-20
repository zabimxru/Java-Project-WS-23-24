package com.gruppe8.frauas.backend;

import java.awt.BorderLayout; //Import of the classes for establishing a connection
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame; //Import of the necessary GUI-libraries
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray; //Import of the necessary JSON-libraries
import org.json.JSONObject;
import org.json.JSONTokener;

public class HelloRest extends JFrame{
    private static final String USER_AGENT = "Mozilla Firefox Awesome version";
    private static final String ENDPOINT_URL = "http://dronesim.facets-labs.com/api/dronetypes/?format=json";
    private static final String TOKEN = "Token 25d3818e0d0fb9288a1be8158fa58ecd4efc8ef9";
	public static final String test = null;

    private DefaultTableModel tableModel;

    public HelloRest() {
        initComponents();
    }

    public void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Drone Catalog");

        tableModel = new DefaultTableModel(new String[]{"ID", "Manufacturer", "Typename", "Weight", "Maximum Speed", "Battery Capacity", "Control Range", "Maximum Carriage"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Fetch data from the API and update the table
        fetchData();
    }

    public void fetchData() {
        System.out.println("Test started...");
        
        int offset = 0;
     
        while(offset!=20) {
        	try {
        	//Construct the URL with the current offset
            URL url = new URL(ENDPOINT_URL + "&limit=10&offset=" + offset);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Process your response
            System.out.println(response.toString());

            // Call the fetchData method with the actual API response
            fetchData(response.toString());
            
            //Increment the offset for the next iteration
            offset += 10;
            
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getLocalizedMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("General IO Exception: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        }
    }
    
    
    public void fetchData(String input) {
        // Add data to the tableModel by using JSON interfaces
        JSONObject wholeFile = new JSONObject(input); //Anstatt so eine Klasse erstellen mit Drohnen und ein Array fängt die Informationen ab und speichert sie in der Klasse ein
        JSONArray jsonFile = wholeFile.getJSONArray("results");
        
        
        for (int i = 0; i < jsonFile.length(); i++) {
            JSONObject o = jsonFile.getJSONObject(i);
            if (o.has("id") && o.has("manufacturer")) {
            	//Extract data from JSON and create a DroneTypes instance 
                int id = o.getInt("id");
                String manufacturer = o.getString("manufacturer");
                String typename = o.getString("typename");
                int weight = o.getInt("weight");
                int max_speed = o.getInt("max_speed");
                int battery_capacity = o.getInt("battery_capacity");
                int control_range = o.getInt("control_range");
                int max_carriage = o.getInt("max_carriage");
                	
                // Add a new row to the tableModel
                tableModel.addRow(new Object[]{id, manufacturer, typename, weight, max_speed, battery_capacity, control_range, max_carriage});
            }
        }
    }

    public static void main(String[] args) {

            HelloRest helloRest = new HelloRest();
            helloRest.setSize(600, 400);
            helloRest.setLocationRelativeTo(null);
            helloRest.setVisible(true);
        
    }
    
}