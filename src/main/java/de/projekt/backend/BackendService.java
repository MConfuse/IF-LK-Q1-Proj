package de.projekt.backend;

import de.nrw.sql.DatabaseConnector;
import de.projekt.Main;

// TODO: Alles mögliche was noch für das Backend wichtig wird
public class BackendService implements IGuiInteractions
{
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
