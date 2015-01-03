package net.trizmo.dungeonCrawler.map;

import net.trizmo.dungeonCrawler.Screen;

public class MapHandler {
	
	public int map[][];
	int maxX, maxY;
	
	public MapHandler(){
	
		map = new int[0][0];
		
	}
	
	/**
	 * Gets what block is in place in a certain position.
	 * @param x :X Coordinate of the tile
	 * @param y :Y coordinate of the tile.
	 * @return id of the 'block' on target tile.
	 */
	public int getBlockFromCoord(int x, int y)
	{
		if(x + 1 < map.length && y + 1 < map[0].length)
		{
			return map[x][y];
		}else {
			return -1;
		}
	}
	/**
	 * Checks if a player or any other person can go on target tile.
	 * @param xPos :X position of target tile.
	 * @param yPos :Y position of target tile.
	 * @return true if player or person can go on target tile.
	 */
	public boolean checkCoordValidPerson(int xPos, int yPos)
	{
		int tileID = map[xPos][yPos];
		if(tileID == 0) return true;
		return false;
	}
	
	public void generateRoom(int x, int y, int side)
	{
		RoomGenerator.generateRoom(x, y, side);
	}

	/**
	 * Used to make the map bigger
	 * @param direction : Direction to extend the map. 1=x 2=y.
	 * @param amountExtend : Amount to extend the map.
	 */
	public void extendMap(int direction, int amountExtend) {
		
		int[][] newMap = null;
		
		if(direction == 1)
		{
			newMap = new int[Screen.mapHandler.map.length + amountExtend][Screen.mapHandler.map[0].length];
			for(int i = 0; i < newMap.length; i++)
			{
				for(int y = 0; y < newMap[0].length; y++)
				{
					if(i < Screen.mapHandler.map.length && y < Screen.mapHandler.map[0].length)
					{
						newMap[i][y] = Screen.mapHandler.map[i][y];
					}else{
						newMap[i][y] = -1;
					}
				}
			}
		} else if(direction == 2)
		{
			newMap = new int[Screen.mapHandler.map.length][Screen.mapHandler.map[0].length + amountExtend];
			for(int x = 0; x < newMap.length; x++)
			{
				for(int y = 0; y < newMap[0].length; y++)
				{
					if(x < Screen.mapHandler.map.length && y < Screen.mapHandler.map[0].length)
					{
						newMap[x][y] = Screen.mapHandler.map[x][y];
					}else {
						newMap[x][y] = -1;
					}
				}
			}
		}
		
		Screen.mapHandler.map = null;
		Screen.mapHandler.map = newMap;
		newMap = null;
	}

	public void pushMap(int side, int amount) {
		
		int[][] map = Screen.mapHandler.map, tempMap;
		
		switch(side) {
		case 1:
			tempMap = new int[Screen.mapHandler.map.length + amount][Screen.mapHandler.map[0].length];
			
			for(int x = 0; x < map.length; x++){
				for(int y = 0; y < map[0].length; y++)
				{
					tempMap[x + amount][y] = map[x][y];
				}
			}
			
			map = null;
			Screen.mapHandler.map = null;
			Screen.mapHandler.map = tempMap;
			tempMap = null;
			
			
			
			
			
			break;
		case 2:
			tempMap = new int[map.length][map[0].length + amount];
			for(int x = 0; x < map.length; x++)
			{
				for(int y = 0; y< map[0].length; y++)
				{
					tempMap[x][y + amount] = map[x][y];
				}
			}
			
			map = null;
			Screen.mapHandler.map = null;
			Screen.mapHandler.map = tempMap;
			tempMap = null;
			
			Screen.pushItems(side, amount);
			
			break;
		}
	}
}
