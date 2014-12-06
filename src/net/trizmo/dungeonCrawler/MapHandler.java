package net.trizmo.dungeonCrawler;

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
}
