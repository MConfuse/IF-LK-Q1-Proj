package de.projekt.gui;

import de.nrw.sql.DatabaseConnector;
import de.projekt.Main;
import de.projekt.backend.BackendService;

import javax.swing.*;
import java.awt.*;

public class GuiLoginCreateAccount
{
	private final JFrame frame = new JFrame("In Account einloggen...");
	private final JPanel panel = new JPanel();

	// --- Login ---

	private final JLabel labelLogin = new JLabel("Login");
	private final JLabel labelLoginName = new JLabel("Name:");
	private final JLabel labelLoginPassword = new JLabel("Passwort:");
	private final JLabel labelLoginStatus = new JLabel("");
	private final JTextField textLoginName = new JTextField();
	private final JPasswordField passwordLoginPassword = new JPasswordField();
	private final JButton buttonLogin = new JButton("Einloggen!");

	// --- Create ---

	private final JLabel labelCreate = new JLabel("Account Erstellen");
	private final JLabel labelCreateName = new JLabel("Name:");
	private final JLabel labelCreatePassword = new JLabel("Passwort:");
	private final JLabel labelCreateStatus = new JLabel("");
	private final JTextField textCreateName = new JTextField();
	private final JTextField textCreatePassword = new JTextField();
	private final JButton buttonCreate = new JButton("Erstellen!");

	public GuiLoginCreateAccount()
	{
		DatabaseConnector connector = Main.connector;

		buttonLogin.setToolTipText("Versucht mit den gegebenen Daten in den Account einzuloggen.");
		buttonLogin.addActionListener(e ->
		{
			labelLoginStatus.setText("Test");
			String passwort = new String(passwordLoginPassword.getPassword());
			connector.executeStatement("SELECT Name, Passwort FROM Personen WHERE Name = \"" + textLoginName.getText() + "\" AND Passwort = \"" + passwort + "\"");
			BackendService.printQueryResult(connector.getCurrentQueryResult());


		});

		buttonLogin.setToolTipText("Versucht mit den gegebenen Daten in den Account einzuloggen.");
		buttonLogin.addActionListener(e ->
		{

		});

		panel.setLayout(null);

		labelLogin.setBounds(10, 10, 40, 25);
		labelLoginName.setBounds(10, 40, 40, 25);
		textLoginName.setBounds(80, 40, 125, 25);
		labelLoginPassword.setBounds(10, 70, 60, 25);
		passwordLoginPassword.setBounds(80, 70, 125, 25);
		buttonLogin.setBounds(220, 50, 125, 30);
		labelLoginStatus.setBounds(220, 80, 125, 25);

		panel.add(labelLogin);
		panel.add(labelLoginName);
		panel.add(textLoginName);
		panel.add(labelLoginPassword);
		panel.add(passwordLoginPassword);
		panel.add(buttonLogin);
		panel.add(labelLoginStatus);

		labelCreate.setBounds(10, 110, 125, 25);
		labelCreateName.setBounds(10, 140, 40, 25);
		textCreateName.setBounds(80, 140, 125, 25);
		labelCreatePassword.setBounds(10, 170, 60, 25);
		textCreatePassword.setBounds(80, 170, 125, 25);
		buttonCreate.setBounds(220, 150, 125, 30);
		labelCreateStatus.setBounds(220, 180, 125, 25);

		panel.add(labelCreate);
		panel.add(labelCreateName);
		panel.add(textCreateName);
		panel.add(labelCreatePassword);
		panel.add(textCreatePassword);
		panel.add(buttonCreate);
		panel.add(labelCreateStatus);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(375, 250));
		frame.pack();
		frame.setVisible(true);
	}

}
