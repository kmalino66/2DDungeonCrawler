package net.trizmo.dungeonCrawler;

import javax.swing.ImageIcon;

public class MapTile {
	
	/**
	 * 0=Floor
	 * 1=Wall
	 * 
	 * 2=Door
	 */
	public static final String[] textureName = new String[] {"Floor", "DungeonWall", ""};
	
	public ImageIcon getTexture(int id)
	{
		if(new ImageIcon("src/net/trizmo/dungeonCrawler/res/" + textureName[id] + ".png").getImage() != null) {
			return new ImageIcon("src/net/trizmo/dungeonCrawler/res/" + textureName[id] + ".png");
		} else {
			return new ImageIcon("src/net/trizmo/dungeonCrawler/res/" + textureName[id] + ".png");
		}
		
	}
}
