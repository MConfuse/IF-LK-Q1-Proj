package de.projekt.backend;

// TODO: Interface Schnittstellen für GUI und BackendService

import de.projekt.backend.product.Produkt;

/**
 * Simuliert eine Schnittstelle mit einer API eines separaten Serversystems.
 */
public interface IGuiInteractions
{
	/**
	 * Versucht den Nutzer in den Account mit gegebenen Anmeldedaten einzuloggen.
	 *
	 * @param name     Der Name des Accounts
	 * @param passwort Das Passwort des Accounts
	 * @return Ein User-Objekt, wenn erfolgreich, oder null, wenn ein Fehler aufgetreten ist
	 */
	User accountLogin(String name, String passwort);

	/**
	 * Erstellt einen neuen Account.
	 *
	 * @param name     Der Name des Accounts
	 * @param passwort Das Passwort des Accounts
	 * @return true, wenn der Account erfolgreich erstellt wurde, false, wenn nicht
	 */
	boolean accountErstellen(String name, String passwort);

	/**
	 * Gibt alle Produktkategorien wieder.
	 *
	 * @return Ein String Array mit allen aktuellen Kategorien
	 */
	String[] gibAlleArtikelKategorien();

	/**
	 * Gibt eine Liste der vorhandenen Produkte der gegebenen Kategorie wieder.
	 *
	 * @param artikelKategorie Die Artikel Kategorie, eine der von {@link #gibAlleArtikelKategorien()} gegebenen
	 *                         Strings
	 * @return Die Produkte der Kategorie, oder null, wenn es diese nicht gibt/ein fehler aufkommt
	 */
	Produkt[] gibAlleProdukteDerKategorie(String artikelKategorie);

}
