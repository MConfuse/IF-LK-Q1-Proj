package de.projekt;

import de.nrw.sql.DatabaseConnector;
import de.projekt.backend.BackendService;
import de.projekt.backend.User;
import de.projekt.files.FileManager;
import de.projekt.gui.GuiLoginCreateAccount;
import de.projekt.gui.GuiMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
	public static final File ORDNER = new File("util/"); // Erstellt am Ausführungsort den util-Ordner
	public static final String NAME = "Einkaufswebseite v0.1";

//	public static GuiMain guiMain = new GuiMain(new BackendService());
	public static DatabaseConnector connector;

	public static User user;

	public Main() throws IOException
	{
		// Erstellen der benötigten Dateien
		FileManager.initialize(ORDNER);

		connector = new DatabaseConnector(null, -1, FileManager.DATENBANK.getAbsolutePath(), null,
				null);

		// Erstellt den Gui-Thread
//		Thread guiThread = new Thread(guiMain, "Gui-Thread");
//		guiThread.start();

		new GuiLoginCreateAccount();


		new Thread(() ->
		{
			String line = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			try
			{
				while ((line = reader.readLine()) != null)
				{

					if (line.equalsIgnoreCase("end"))
					{
						System.out.println("Programm wird beendet...");
						GuiMain.getInstance().setRunning(false);
						System.exit(0);
						break;
					}

				}

			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}, "Console Thread").start();
	}

	public static void main(String[] args) throws IOException
	{
		new Main();
	}

}
