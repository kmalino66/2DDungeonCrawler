package net.trizmo.dungeonCrawler;

public class MapHandler {
	
	public int map[][];
	int maxX, maxY;
	
	public MapHandler(){
	
		map = new int[0][0];
		
	}
	
	public int getBlockFromCoord(int x, int y)
	{
		if(x + 1 < map.length && y + 1 < map[0].length)
		{
			return map[x][y];
		}else {
			return -1;
		}
	}
}
