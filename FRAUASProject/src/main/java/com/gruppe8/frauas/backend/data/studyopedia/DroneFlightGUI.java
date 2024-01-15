import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DroneFlightGUI extends JFrame {
	private OverviewDrone drone; //Assuming we have a selected drone
	
	public DroneFlightGUI(OverviewDrone drone) {
		this.drone = drone;
		initComponents();
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
