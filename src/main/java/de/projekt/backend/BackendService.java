package de.projekt.backend;

import de.nrw.sql.DatabaseConnector;
import de.nrw.sql.QueryResult;
import de.projekt.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// TODO: Alles mögliche was noch für das Backend wichtig wird
public class BackendService implements IGuiInteractions
{
	private static final DatabaseConnector connector = Main.connector;

	public static void printQueryResult(QueryResult result)
	{
		for (int y = 0; y < result.getRowCount(); y++)
		{
			for (int x = 0; x < result.getColumnCount(); x++)
			{
				System.out.print(result.getData()[y][x] + " ");
			}

			System.out.println("\r");
		}

	}

	@Override
	public User accountLogin(String name, String passwort)
	{
		connector.executeStatement("SELECT Uuid, Name, Passwort FROM Personen WHERE Name = \"" + name + "\" AND " +
				"Passwort = \"" + passwort + "\"");
		BackendService.printQueryResult(connector.getCurrentQueryResult());

		if (connector.getCurrentQueryResult() == null || connector.getCurrentQueryResult().getData() == null || connector.getCurrentQueryResult().getData().length == 0)
		{
			// Fehlgeschlagen, kein Account gefunden
			return null;
		}

		return new User(UUID.fromString(connector.getCurrentQueryResult().getData()[0][0]),
				connector.getCurrentQueryResult().getData()[0][1]);
	}

	@Override
	public boolean accountErstellen(String name, String passwort)
	{
		connector.executeStatement("SELECT Name FROM Personen WHERE Name = \"" + name + "\"");
		BackendService.printQueryResult(connector.getCurrentQueryResult());

		if (connector.getCurrentQueryResult() == null || connector.getCurrentQueryResult().getData() == null || connector.getCurrentQueryResult().getData().length != 0)
		{
			// Fehlgeschlagen, der Account existiert bereits | Anderer DB Fehler
			return false;
		}

		connector.executeStatement("INSERT INTO Personen(Uuid, Name, Passwort) VALUES(\"" + User.generateType1UUID() +
				"\", \"" + name + "\", \"" + passwort + "\")");
		return true;
	}

	@Override
	public String[] gibAlleProduktKategorien()
	{
		connector.executeStatement("SELECT Artikelart FROM Produkte GROUP BY Artikelart");
		QueryResult result = connector.getCurrentQueryResult();
		List<String> stringList = new ArrayList<>();

		for (int y = 0; y < result.getRowCount(); y++)
			stringList.add(result.getData()[y][0]);

		return new String[0];
	}

}
