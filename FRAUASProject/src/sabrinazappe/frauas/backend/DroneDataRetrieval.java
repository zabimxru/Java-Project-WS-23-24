package sabrinazappe.frauas.backend;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import java.io.PrintStream; //Basis:https://stackoverflow.com/questions/5107629/how-to-redirectconsole-content-to-a-textarea-in-java

public class DroneDataRetrieval {

	// program entrypoint
	private static JTextArea textArea;

	public static void main(String[] args) {
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
