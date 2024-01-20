package com.gruppe8.frauas.backend;
//Necessary Java classes for GUI, event handling and IO
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.JButton;
import java.io.OutputStream;
import java.io.PrintStream; 

//Class to handle GUI and data processing for drone info
public class DroneDataProcess {
	//Text area to display output
	private static JTextArea textArea;
	//Program entry point
	public static void main(String[] args) {
		// Execute GUI creation and output redirection on the event dispatch thread
		SwingUtilities.invokeLater(() -> {
		    CreateGUI();
		    redirectOutput();
		});
	}
	
	//Method to create the GUI
	public static void CreateGUI() {
			//Create a JFrame for the application
			JFrame frame = new JFrame();
			frame.setSize(1000, 1000);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//Create a JTextAera to display output
			textArea = new JTextArea();
			Container container = frame.getContentPane();
			container.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			//Create buttons for fetching data from different endpoints
			JButton droneButton = new JButton("Fetch Data from Drones site.");
			JButton dynamicButton = new JButton("Fetch Data from the Dynamic site.");
			JButton typeButton = new JButton("Fetch Data from the Typ site. ");
			
			//Set up buttons and add them to the container
			setupButton(container, droneButton, "drones");
			setupButton(container, dynamicButton, "dronedynamics");
			setupButton(container, typeButton, "dronetypes");
			
			//Add the JTextArea to the container
			container.add(textArea);
			frame.setVisible(true);
			
	}
	
	//Method to append text to the JTextArea
	private static void appendTextArea(String text) {
		textArea.append(text + "\n");
	}

	//Method to redirect System.out and System.err to the JTextArea
	private static void redirectOutput() {
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
		System.setOut(printStream); //Capture the intended output and send it to textArea
		System.setErr(printStream); //Also capture error messages and print them on textArea
	}

	// Method to set up a button with a specified endpoint and action listener
	private static void setupButton(Container container, JButton button, String endpoint) {
		button.setBounds(100, container.getComponentCount()* 60 + 10, 200, 40);
		container.add(button);
	
		//Add an action listener to the button
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					//Fetch data from the specified endpoint and display it in the JTextArea
					String rawData = APIAuthentication.fetchData(endpoint);
					appendTextArea("Raw JSON data: " + rawData);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//CustomOutputStream class to redirect output to the JTextArea
	static class CustomOutputStream extends OutputStream {
		private JTextArea textArea;
		private boolean insideSquareBracket;
	
		public CustomOutputStream(JTextArea textArea) {
			this.textArea = textArea;
			this.insideSquareBracket = false;
		}
		
		//Override write method to redirect output
		@Override
		public void write(int b) {
			//Redirect output to the JTextArea
			char character = (char) b;
			textArea.append(String.valueOf(character));
			//Not yet working
			//Check if the character is an open curly brace
			if(character == '}') {
				insideSquareBracket = false;
			}
		
			//Check if the character is an open square bracket
			if(character == '[') {
				insideSquareBracket = true;
			}
		
			if(character == ']' && !insideSquareBracket) {
				textArea.append("\n");
			}
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}	
	}
}