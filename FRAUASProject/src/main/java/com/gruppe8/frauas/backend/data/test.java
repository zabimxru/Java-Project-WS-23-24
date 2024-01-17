package com.gruppe8.frauas.backend.data;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.gruppe8.frauas.backend.data.studyopedia.DroneApp;
import com.gruppe8.frauas.backend.data.studyopedia.DroneStatus;
import com.gruppe8.frauas.backend.data.studyopedia.FlightDynamics;

import javax.swing.JButton;

public class test {

	private JFrame frame;
	private HelloRest helloRest; //Instance of the HelloRest-class
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		helloRest = new HelloRest(); //Initialize the HelloRest class
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Drone Simulator Project");
		lblWelcomeToThe.setBounds(66, 12, 284, 15);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblWhatIsYour = new JLabel("What is your inquiry?");
		lblWhatIsYour.setBounds(133, 39, 150, 15);
		frame.getContentPane().add(lblWhatIsYour);
		
		JButton btnViewStatus = new JButton("View status");
		btnViewStatus.setBounds(133, 66, 150, 25);
		frame.getContentPane().add(btnViewStatus);
		
		JButton btnViewCatalog = new JButton("View catalog");
		btnViewCatalog.setBounds(133, 107, 150, 25);
		frame.getContentPane().add(btnViewCatalog);
		
		
		JButton btnViewFlightDynamics = new JButton("View flight dynamics");
		btnViewFlightDynamics.setBounds(119, 150, 179, 25);
		frame.getContentPane().add(btnViewFlightDynamics);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(136, 233, 147, 25);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnViewDashboard = new JButton("View Dashboard");
		btnViewDashboard.setBounds(119, 187, 179, 25);
		frame.getContentPane().add(btnViewDashboard);
		
		btnViewCatalog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Calling the fetchhData-method of the HelloRest-class
				helloRest.fetchData();
				
				//Use the table from the HelloRest class to display the data
				helloRest.initComponents();
				
				
				//Set frame properties
				helloRest.setSize(600, 400);
				helloRest.setLocationRelativeTo(null); //Center the frame on the screen
				helloRest.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Close only the second frame
				helloRest.setVisible(true);
			}
		});
		
		btnViewStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Code to open another frame
				DroneStatus droneStatus = new DroneStatus();
				
				//Set frame properties
				droneStatus.setSize(800,600);
				droneStatus.setLocationRelativeTo(null);
				droneStatus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				droneStatus.setVisible(true);
			}
		});
		
		btnViewDashboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Code to open the frame
				DroneApp droneApp = new DroneApp();
				
				//Set frame properties
				droneApp.setSize(800,600);
				droneApp.setLocationRelativeTo(null);
				droneApp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				droneApp.setVisible(true);
			}
		});
		btnViewFlightDynamics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Code to open another frame
				FlightDynamics flightDynamics = new FlightDynamics();
				flightDynamics.setLocationRelativeTo(null);
				flightDynamics.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				flightDynamics.setVisible(true);
			}
		});
	}
}
