package com.gruppe8.frauas.backend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataRefresh extends JFrame {
	private APIAuthentication apiAuthentication;

	private JTextArea dataTextArea;

	public DataRefresh(APIAuthentication apiAuthentication) {
		this.apiAuthentication = apiAuthentication;

		setTitle("API Data Updater");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initComponents();
	}

	private void initComponents() {
		dataTextArea = new JTextArea();
		dataTextArea.setEditable(false);

		JButton updateButton = new JButton("Update Data");
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateData();
			}
		});

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JScrollPane(dataTextArea), BorderLayout.CENTER);
		panel.add(updateButton, BorderLayout.SOUTH);

		add(panel);
	}

	private void updateData() {
		// Hier wird die APIAuthentication-Klasse verwendet, um Daten von der API zu
		// ziehen
		String apiData = apiAuthentication.fetchData("deine-endpoint-hier"); // Hier sollte der gewünschte Endpunkt
																				// eingetragen werden

		// Die aktualisierten Daten werden in das Textfeld gesetzt
		dataTextArea.setText(apiData);
	}

//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				APIAuthentication apiAuthentication = new APIAuthentication();
//				DataRefresh dataRefresh = new DataRefresh(apiAuthentication);
//				dataRefresh.setVisible(true);
//			}
//		});
//	}
}
