package de.projekt.gui;

import de.projekt.Main;
import de.projekt.backend.BackendService;
import de.projekt.backend.IGuiInteractions;
import de.projekt.backend.product.Produkt;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

// TODO: Das Ganze GUI mithilfe von Java AWT
public class GuiMain implements Runnable
{
	public static GuiMain instance;

	private final IGuiInteractions guiInteractions;
	private final String[] artikelarten;
	/**
	 * Speichert alle Produkte der aktuellen Artikelart.
	 */
	private Produkt[] produktCache;

	private final JFrame frame = new JFrame(Main.NAME);

	private final JSplitPane splitPaneArtikelartProdukte = new JSplitPane();
	private final JList<String> listArtikelart = new JList<>();
	private final JSplitPane splitPaneProdukteInfo = new JSplitPane();
	private final JPanel paneProduktInfo = new JPanel();

	private boolean running = true;

	public GuiMain(BackendService backendService)
	{
		guiInteractions = backendService;
		artikelarten = guiInteractions.gibAlleArtikelKategorien();

		listArtikelart.setListData(artikelarten);
		listArtikelart.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting())
			{
				System.out.println(listArtikelart.getSelectedValue());
				produktCache = guiInteractions.gibAlleProdukteDerKategorie(listArtikelart.getSelectedValue());
			}
		});
		splitPaneArtikelartProdukte.setLeftComponent(listArtikelart);
		splitPaneArtikelartProdukte.setRightComponent(splitPaneProdukteInfo);

		// --- Setting up the Frame ---
		frame.setSize(350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(splitPaneArtikelartProdukte);
		//		frame.setJMenuBar(menu);
		frame.setMinimumSize(new Dimension(343, 230));
		frame.pack();
		frame.setVisible(true);
	}

	public static GuiMain getInstance()
	{
		if (instance == null)
			instance = new GuiMain(new BackendService());

		return instance;
	}

	@Override
	public void run()
	{
		/*
		 * Für den Fall, dass wir noch etwas hier machen müssen, was asynchron ist - unwahrscheinlich aber wichtig.
		 */

		while (running)
		{

		}

	}

	public void setRunning(boolean running)
	{
		this.running = running;
	}
}
