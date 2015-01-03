package net.trizmo.dungeonCrawler.graphics;

import java.awt.Color;
import java.awt.Graphics;

import net.trizmo.dungeonCrawler.MessageHandler;
import net.trizmo.dungeonCrawler.Screen;
import net.trizmo.dungeonCrawler.graphics.MenuButton;

public class GraphicsManager {

	/**
	 * Called when the scene is changed.
	 * 0 = Menu screen
	 * 100 = Game Screen
	 * @param oldScene
	 * @param newScene
	 */
	public static void sceneChanged(int oldScene, int newScene)
	{
		if(oldScene == 0) neededSceneItems0(0);
		if(newScene == 0) neededSceneItems0(1);
	}

	public static void drawScene0(Graphics g)
	{
		if(Screen.menuButtons != null) {
			for(int i = 0; i < Screen.menuButtons.length; i++)
			{
				if(Screen.menuButtons[i] != null) Screen.menuButtons[i].drawComponent(g);
			}
		}
	}

	public static void drawScene1(Graphics g)
	{

	}

	private static void neededSceneItems0(int mode)
	{
		//Mode = 1= create 0= destroy
		if(mode == 0)
		{
			Screen.menuButtons = null;
		}else if(mode == 1)
		{
			Screen.menuButtons = new MenuButton[3];
			Screen.menuButtons[0] = new MenuButton((int)(Screen.width - (Screen.boxSize *2.5)), Screen.boxSize, Screen.boxSize * 5, Screen.boxSize, "noTexture", Color.black, "New Game");
			Screen.menuButtons[1] = new MenuButton((int)(Screen.width - (Screen.boxSize * 2.5)), Screen.boxSize * 2 + 10, Screen.boxSize * 5, Screen.boxSize, "noTexture", Color.BLACK, "Resume Saved Game");
			Screen.menuButtons[2] = new MenuButton((int)(Screen.width - (Screen.boxSize * 2.5)), Screen.boxSize * 2 + 20, Screen.boxSize * 5, Screen.boxSize, "noTexture", Color.black, "Exit");
			MessageHandler.resourceCreated("Scene 0 items.");
		}
	}
}
