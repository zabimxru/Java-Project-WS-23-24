package com.gruppe8.frauas.backend.data.studyopedia;

import java.awt.BorderLayout; //Import of the classes for establishing a connection
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame; //Import of the necessary GUI-libraries
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray; //Import of the necessary JSON-libraries
import org.json.JSONObject;
import org.json.JSONTokener;

public class FlightChart extends JFrame{
    private static final String USER_AGENT = "Mozilla Firefox Awesome version";
    private static final String ENDPOINT_URL = "http://dronesim.facets-labs.com/api/dronedynamics/?format=json";
    private static final String TOKEN = "Token 25d3818e0d0fb9288a1be8158fa58ecd4efc8ef9";

    private DefaultTableModel tableModel;

    public FlightChart() {
        initComponents();
    }

    public void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Drone Dynamics");

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
        JSONObject droneDynamicsObject = new JSONObject(input); //Anstatt so eine Klasse erstellen mit Drohnen und ein Array fängt die Informationen ab und speichert sie in der Klasse ein
        JSONArray droneDynamicsArray = droneDynamicsObject.getJSONArray("results");
        
        
        for (int i = 0; i < droneDynamicsArray.length(); i++) {
            JSONObject droneDynamicsData = droneDynamicsArray.getJSONObject(i);
            
            //Extract data from drone dynamics JSON
            String droneLink = droneDynamicsData.getString("drone");
            Date timestamp; //Parse timestamp in any way
            
            //Fetch drone details using the drone link
            fetchDroneDetails(droneLink);
            }
        }
    
    public void fetchDroneDetails(String droneLink) {
        try {
            // Construct the URL for the drone details
            URL url = new URL(droneLink);
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

            // Process drone details data
            processDroneDetails(response.toString());
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getLocalizedMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("General IO Exception: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
    
    public void processDroneDetails(String input) {
        // Add logic to process and display drone details data
        JSONObject droneDetailsObject = new JSONObject(input);

        // Extract relevant data from drone details JSON
        int id = droneDetailsObject.getInt("id");
        String droneType = droneDetailsObject.getString("dronetype");
        String created = droneDetailsObject.getString("created");
        String serialNumber = droneDetailsObject.getString("serialnumber");
        int carriageWeight = droneDetailsObject.getInt("carriage_weight");
        String carriageType = droneDetailsObject.getString("carriage_type");

        // Create an instance of DroneDetails and use the data as needed
        OverviewDrone droneDetails = new OverviewDrone(id, droneType, created, serialNumber, carriageWeight, carriageType);

        // Example: Print the drone details to the console
        System.out.println(droneDetails.toString());
    }

    public static void main(String[] args) {

            FlightChart flightchart = new FlightChart();
            flightchart.setSize(600, 400);
            flightchart.setLocationRelativeTo(null);
            flightchart.setVisible(true);
        
    }
    
}