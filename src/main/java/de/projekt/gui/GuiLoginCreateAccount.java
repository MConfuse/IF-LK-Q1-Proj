package de.projekt.gui;

import de.projekt.Main;
import de.projekt.backend.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

import static de.projekt.Main.backendService;
import static de.projekt.Main.guiMain;

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
		buttonLogin.setToolTipText("Versucht mit den gegebenen Daten in den Account einzuloggen.");
		buttonLogin.addActionListener(e ->
		{
			labelLoginStatus.setText("Logge ein...");
			User user = backendService.accountLogin(textLoginName.getText(),
					new String(passwordLoginPassword.getPassword()));

			if (user == null)
			{
				labelLoginStatus.setText("Login Fehlgeschlagen!");
				return;
			}

			labelLoginStatus.setText("Login Erfolgreich!");
			try
			{
				Thread.sleep(500); // Delay zwischen Nachricht und ändern des GUI, für verbesserte Nutzererfahrung
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}

			// Schließt login Fenster, öffnet Hauptfenster
			frame.setVisible(false);
			guiMain = new GuiMain(backendService);
			// Erstellt den Gui-Thread
			Thread guiThread = new Thread(guiMain, "Gui-Thread");
			guiThread.start();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		});

		buttonCreate.setToolTipText("Versucht mit den gegebenen Daten in den Account einzuloggen.");
		buttonCreate.addActionListener(e ->
		{
			labelCreateStatus.setText("Creating Account...");

			if (backendService.accountErstellen(textCreateName.getText(), textCreatePassword.getText()))
				labelCreateStatus.setText("Account Erstellt!");
			else
				labelCreateStatus.setText("Account existiert!");
		});

		panel.setLayout(null);

		labelLogin.setBounds(10, 10, 40, 25);
		labelLoginName.setBounds(10, 40, 40, 25);
		textLoginName.setBounds(80, 40, 125, 25);
		labelLoginPassword.setBounds(10, 70, 60, 25);
		passwordLoginPassword.setBounds(80, 70, 125, 25);
		buttonLogin.setBounds(220, 50, 125, 30);
		labelLoginStatus.setBounds(220, 80, 135, 25);

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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setMinimumSize(new Dimension(375, 250));
		frame.pack();
		frame.setVisible(true);
	}

}
