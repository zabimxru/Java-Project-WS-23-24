package com.gruppe8.frauas.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gruppe8.frauas.backend.data.DroneListData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DroneDataRetrieval {

	// program entrypoint
	private static JTextArea textArea;

	public static void main(String[] args) {

		String testJson = "{\n" +
				"    \"count\": 25,\n" +
				"    \"next\": \"http://dronesim.facets-labs.com/api/drones/?limit=10&offset=10\",\n" +
				"    \"previous\": null,\n" +
				"    \"results\": [\n" +
				"        {\n" +
				"            \"id\": 71,\n" +
				"            \"dronetype\": \"http://dronesim.facets-labs.com/api/dronetypes/85/\",\n" +
				"            \"created\": \"2023-12-27T09:07:00.678852+01:00\",\n" +
				"            \"serialnumber\": \"HoHS-2024-F26CA5\",\n" +
				"            \"carriage_weight\": 387,\n" +
				"            \"carriage_type\": \"SEN\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 72,\n" +
				"            \"dronetype\": \"http://dronesim.facets-labs.com/api/dronetypes/88/\",\n" +
				"            \"created\": \"2023-12-27T09:07:00.684029+01:00\",\n" +
				"            \"serialnumber\": \"SnS5-2030-360F05\",\n" +
				"            \"carriage_weight\": 73,\n" +
				"            \"carriage_type\": \"ACT\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 73,\n" +
				"            \"dronetype\": \"http://dronesim.facets-labs.com/api/dronetypes/72/\",\n" +
				"            \"created\": \"2023-12-27T09:07:00.686755+01:00\",\n" +
				"            \"serialnumber\": \"HuX4-2028-208EA8\",\n" +
				"            \"carriage_weight\": 27,\n" +
				"            \"carriage_type\": \"ACT\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 74,\n" +
				"            \"dronetype\": \"http://dronesim.facets-labs.com/api/dronetypes/85/\",\n" +
				"            \"created\": \"2023-12-27T09:07:00.689302+01:00\",\n" +
				"            \"serialnumber\": \"HoHS-2030-13725D\",\n" +
				"            \"carriage_weight\": 499,\n" +
				"            \"carriage_type\": \"ACT\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 75,\n" +
				"            \"dronetype\": \"http://dronesim.facets-labs.com/api/dronetypes/86/\",\n" +
				"            \"created\": \"2023-12-27T09:07:00.691570+01:00\",\n" +
				"            \"serialnumber\": \"RyTe-2027-1F9086\",\n" +
				"            \"carriage_weight\": 0,\n" +
				"            \"carriage_type\": \"NOT\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 76,\n" +
				"            \"dronetype\": \"http://dronesim.facets-labs.com/api/dronetypes/85/\",\n" +
				"            \"created\": \"2023-12-27T09:07:00.693650+01:00\",\n" +
				"            \"serialnumber\": \"HoHS-2022-00A010\",\n" +
				"            \"carriage_weight\": 388,\n" +
				"            \"carriage_type\": \"SEN\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 77,\n" +
				"            \"dronetype\": \"http://dronesim.facets-labs.com/api/dronetypes/74/\",\n" +
				"            \"created\": \"2023-12-27T09:07:00.695779+01:00\",\n" +
				"            \"serialnumber\": \"PoPo-2031-94D838\",\n" +
				"            \"carriage_weight\": 429,\n" +
				"            \"carriage_type\": \"ACT\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 78,\n" +
				"            \"dronetype\": \"http://dronesim.facets-labs.com/api/dronetypes/85/\",\n" +
				"            \"created\": \"2023-12-27T09:07:00.697895+01:00\",\n" +
				"            \"serialnumber\": \"HoHS-2026-DD1078\",\n" +
				"            \"carriage_weight\": 0,\n" +
				"            \"carriage_type\": \"NOT\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 79,\n" +
				"            \"dronetype\": \"http://dronesim.facets-labs.com/api/dronetypes/71/\",\n" +
				"            \"created\": \"2023-12-27T09:07:00.700019+01:00\",\n" +
				"            \"serialnumber\": \"GoKa-2031-AD19BD\",\n" +
				"            \"carriage_weight\": 22,\n" +
				"            \"carriage_type\": \"SEN\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"id\": 80,\n" +
				"            \"dronetype\": \"http://dronesim.facets-labs.com/api/dronetypes/89/\",\n" +
				"            \"created\": \"2023-12-27T09:07:00.701950+01:00\",\n" +
				"            \"serialnumber\": \"PoD8-2031-B53F1D\",\n" +
				"            \"carriage_weight\": 44,\n" +
				"            \"carriage_type\": \"SEN\"\n" +
				"        }\n" +
				"    ]\n" +
				"}";



		ObjectMapper mapper = new ObjectMapper();
		DroneListData data = null;
		try {
			data = mapper.readValue(testJson, DroneListData.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		long idOfDrone1 = data.getResults()[0].getId();



		System.out.println(data);


		try { // try-catch -> handle any exceptions that might come up
			// I define the API endpoint for fetching the drone data
			String droneendpoint = "drones";
			String dynamicsendpoint = "dronedynamics";
			String typesendpoint = "dronetypes";
			JFrame frame = new JFrame();
			frame.setSize(400, 500);
			frame.setVisible(true);
			textArea = new JTextArea();
			Container container = frame.getContentPane();
			JButton dronebutton = new JButton("Fetch Data from Drones site.");
			dronebutton.setBounds(100, 10, 200, 40);
			container.add(dronebutton);
			JButton dynamicbutton = new JButton("Fetch Data from the Dynamic site.");
			dynamicbutton.setBounds(100, 70, 200, 40);
			container.add(dynamicbutton);
			JButton typbutton = new JButton("Fetch Data from the Typ site. ");
			typbutton.setBounds(100, 130, 200, 40);
			container.add(typbutton);
			dronebutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent dr) {
					String rawDataDrone = APIAuthentication.fetchData(droneendpoint);
					appendTextArea("Raw JSON data: " + rawDataDrone);

				}
			});
			dynamicbutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent dym) {
					String rawDataDynamic = APIAuthentication.fetchData(dynamicsendpoint);
					appendTextArea("Raw JSON data: " + rawDataDynamic);
				}
			});
			typbutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ty) {
					String rawDataType = APIAuthentication.fetchData(typesendpoint);
					appendTextArea("Raw JSON data: " + rawDataType);
				}
			});
		} catch (Exception e) {
			// If their is an exception during run, print the trace for debugging
			e.printStackTrace();
		}
	}

	private static void appendTextArea(String text) {
		textArea.append(text + "\n");
	}
}
