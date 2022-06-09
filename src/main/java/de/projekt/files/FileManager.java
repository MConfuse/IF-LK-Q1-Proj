package de.projekt.files;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

/**
 * Der FileManager ist dafür gedacht, Dateiverweise einfach an einem zentralen Ort zu haben. Stellt außerdem beim Start
 * sicher, dass alle Dateien erstellt werden können.
 */
public class FileManager
{
	/**
	 * Der Verweis an die Datenbank Datei.
	 */
	public static File DATENBANK;

	public static void initialize(@NotNull File dateiOrdner) throws IOException
	{
		if (dateiOrdner.mkdir())
			System.out.println("FileManager.initialize: Ordner erstellt!");

		DATENBANK = new File(dateiOrdner, "Einkaufswebsite.db");
		DATENBANK.createNewFile();
	}

}
