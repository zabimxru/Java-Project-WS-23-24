package sabrinazappe.frauas.backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;


public class APIDataRefresh {
	
	
	JButton refreshButton = new JButton("Daten aktualisieren");
	refreshButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {}
		aktualisiereDaten() {
		}
	});
	public void aktualisiereDaten() {
		APIAuthentication datarefresh = new APIAuthentication();
		
	}
	
	public void anzeigeDaten(JSONObject data) {
	    // Hier kannst du die Daten in deiner GUI anzeigen
	    // Beispiel: label.setText("Batterielevel: " + data.getString("batteryLevel"));
	}

	    


}
