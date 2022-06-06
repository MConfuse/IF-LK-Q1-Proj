package de.projekt.gui;

import de.projekt.backend.IGuiInteractions;

// TODO: Das Ganze GUI mithilfe von Java AWT
public class GuiMain implements Runnable
{
	public static GuiMain instance;

	private IGuiInteractions guiInteractions;

	public GuiMain()
	{
	}

	public static GuiMain getInstance()
	{
		if (instance == null)
			instance = new GuiMain();

		return instance;
	}

	@Override
	public void run()
	{
		/*
		 * Für den Fall, dass wir noch etwas hier machen müssen, was asynchron ist - unwahrscheinlich aber wichtig.
		 */

	}
}
