package de.projekt.backend.product;

/**
 * Generische Klasse, die für alle Produkte im Shop anwendbar ist; kann extended werden, falls spezifischere
 * Funktionalität gewünscht ist.
 */
public record Produkt(int artikelNummer, String artikelart, String name, float preis, String beschreibung, boolean verfuegbar)
{
	@Override
	public String toString()
	{
		return "Produkt{" +
				"artikelNummer=" + artikelNummer +
				", artikelart='" + artikelart + '\'' +
				", name='" + name + '\'' +
				", preis=" + preis +
				", beschreibung='" + beschreibung + '\'' +
				", verfuegbar=" + verfuegbar +
				'}';
	}
}
