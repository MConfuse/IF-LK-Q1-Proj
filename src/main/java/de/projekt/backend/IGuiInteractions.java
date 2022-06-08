package de.projekt.backend;

// TODO: Interface Schnittstellen für GUI und BackendService
public interface IGuiInteractions
{
	User accountLogin(String user, String passwort);

	User accountErstellen(String user, String passwort);

}
