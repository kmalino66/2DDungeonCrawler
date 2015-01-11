package net.trizmo.dungeonCrawler.graphics;

import java.awt.Color;
import java.awt.Graphics;

import net.trizmo.dungeonCrawler.MessageHandler;
import net.trizmo.dungeonCrawler.Screen;
import net.trizmo.dungeonCrawler.graphics.MenuButton;

public class GraphicsManager {

	/**
	 * Called when the scene is changed.
	 * 0 = Menu screen - (This is the startup screen).
	 * 100 = Game Screen - (This is the actual dungeon screen).
	 * @param oldScene - The old scene. Needed to destroy objects no longer needed.
	 * @param newScene - The new scene. Needed to create objects needed for the scene.
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

	/**
	 * This method is meant to draw all of the things needed on the "game screen"
	 * @param g
	 */
	public static void drawScene100(Graphics g)
	{
		int screenX = (Screen.screenPosBounds[0] / 2) * Screen.boxSize, screenY = (Screen.screenPosBounds[1] / 2) / Screen.boxSize;
		int startX = Screen.player.getX() - (Screen.screenPosBounds[0] / 2), startY = Screen.player.getY() - (Screen.screenPosBounds[1] / 2);
		
		for(int x = startX; x < startX + Screen.screenPosBounds[0]; x++)
		{
			for(int y = startY; y < startY + Screen.screenPosBounds[1]; y++)
			{
				if(x > 0 && x < Screen.mapHandler.map.length && y > 0 && y < Screen.mapHandler.map[0].length)
				{
					
				}
			}
		}
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
			Screen.menuButtons[0] = new MenuButton((int)(Screen.width * .5 - (Screen.boxSize *2.5)), Screen.boxSize, Screen.boxSize * 5, Screen.boxSize, "noTexture", Color.black, "New Game");
			Screen.menuButtons[1] = new MenuButton((int)(Screen.width * .5 - (Screen.boxSize * 2.5)), Screen.boxSize * 2 + 10, Screen.boxSize * 5, Screen.boxSize, "noTexture", Color.BLACK, "Resume Saved Game");
			Screen.menuButtons[2] = new MenuButton((int)(Screen.width * .5 - (Screen.boxSize * 2.5)), Screen.boxSize * 3 + 20, Screen.boxSize * 5, Screen.boxSize, "noTexture", Color.black, "Exit");
			MessageHandler.resourceCreated("Scene 0 items.");
		}
	}
}
