package de.projekt;

import de.nrw.sql.DatabaseConnector;
import de.projekt.files.FileManager;
import de.projekt.gui.GuiMain;

import java.io.File;
import java.io.IOException;

public class Main
{
	public static final File ORDNER = new File("util/"); // Erstellt am Ausführungsort den util-Ordner

	public static final GuiMain GUI_MAIN = new GuiMain();
	public static DatabaseConnector connector;

	public Main() throws IOException
	{
		// Erstellen der benötigten Dateien
		FileManager.initialize(ORDNER);

		connector = new DatabaseConnector(null, -1, FileManager.DATENBANK.getAbsolutePath(), null,
				null);

		// Erstellt den Gui-Thread
		Thread guiThread = new Thread(GUI_MAIN, "Gui-Thread");
		guiThread.start();
	}

	public static void main(String[] args) throws IOException
	{
		new Main();
	}

}
