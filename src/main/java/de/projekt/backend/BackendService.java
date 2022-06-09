package de.projekt.backend;

import de.nrw.sql.DatabaseConnector;
import de.nrw.sql.QueryResult;
import de.projekt.Main;

// TODO: Alles mögliche was noch für das Backend wichtig wird
public class BackendService implements IGuiInteractions
{
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

	private static final DatabaseConnector connector = Main.connector;

	@Override
	public User accountLogin(String user, String passwort)
	{
		return null;
	}

	@Override
	public User accountErstellen(String user, String passwort)
	{
		return null;
	}

}
