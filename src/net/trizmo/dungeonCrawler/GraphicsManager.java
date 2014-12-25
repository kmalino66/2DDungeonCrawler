package net.trizmo.dungeonCrawler;

import java.awt.Color;
import java.awt.Graphics;

import net.trizmo.dungeonCrawler.graphics.MenuButton;

public class GraphicsManager {

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

		}else if(mode == 1)
		{
			Screen.menuButtons = new MenuButton[2];
			Screen.menuButtons[0] = new MenuButton(10, 10, 50, 50, "noTexture", Color.black, "hello");
			MessageHandler.resourceCreated("Scene 0 items.");
		}
	}
}
