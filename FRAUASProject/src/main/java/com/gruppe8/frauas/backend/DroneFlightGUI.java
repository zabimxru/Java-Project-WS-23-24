package com.gruppe8.frauas.backend;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.gruppe8.frauas.backend.data.OverviewDrone;
import com.gruppe8.frauas.backend.data.OverviewDroneDynamics;

public class DroneFlightGUI extends JFrame {
	private static final String USER_AGENT = "Mozilla Firefox Awesome version";
    private static final String ENDPOINT_URL = "http://dronesim.facets-labs.com/api/dronedynamics/?format=json";
    private static final String TOKEN = "Token 25d3818e0d0fb9288a1be8158fa58ecd4efc8ef9";
	
    public DroneFlightGUI() {
        initComponents();
        HelloRest.test;
	}
	
	private void initComponents() {
		JLabel speedLabel = new JLabel("Speed:");
		JLabel alignmentRollLabel = new JLabel("Alignment Roll:");
		
		//Fetch and display drone dynamics
		List<OverviewDroneDynamics> droneDynamics = drone.getDroneDynamics();
		if(droneDynamics != null && !droneDynamics.isEmpty()) {
			OverviewDroneDynamics latestDynamic = droneDynamics.get(droneDynamics.size()-1);
			
			// Display flight parameters in UI components
			speedLabel.setText("Speed: " + latestDynamic.getSpeed());
			alignmentRollLabel.setText("Alignment Roll: " + latestDynamic.getAlignmentRoll());
			//Update other UI components with relevant data
		}
		
		//Add UI components to the JFrame and set layout, etc.
	}
	
	public static void main(String[] args) {
		//Assume you have an instance of OverviewDrone
		OverviewDrone selectedDrone = new OverviewDrone();
		//Initialize drone date, including dynamics
		
		DroneFlightGUI gui = new DroneFlightGUI (selectedDrone);
		gui.setSize(400,300);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
}
