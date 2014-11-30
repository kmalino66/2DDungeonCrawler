package net.trizmo.dungeonCrawler;

import javax.swing.ImageIcon;

public class MapTile {
	
	public static final String[] textureName = new String[] {};
	
	public ImageIcon getTexture(int id)
	{
		return new ImageIcon("src/net/trizmo/dungeonCrawler/res/" + textureName + ".png");
	}
}
