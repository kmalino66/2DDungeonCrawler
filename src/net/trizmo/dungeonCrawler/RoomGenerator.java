package net.trizmo.dungeonCrawler;

import java.awt.Point;
import java.util.Random;

public class RoomGenerator {

	/** Gets bounds that the a generated room must fit into.
	 * 
	 * @param x :X position of the start generation point.
	 * @param y :Y position of the start generation point.
	 * @param side :What side the startpoint is on in reletive to other rooms. 0=up 1=right 2=down 3=left.
	 * @return The x and y bounds of the maximum room size. [upper, right, down, left].
	 */
	public static int[] getRoomBounds(int x, int y, int side)
	{
		int rightBound = -1, leftBound = -1, upperBound = -1, lowerBound = -1;

		if(side == 0)
		{
			//Find the upper bound.
			for(int i = y - 1; i > 0; i--)
			{
				if(Screen.mapHandler.map[x][i] == 1 || Screen.mapHandler.map[x][i] == 2)
				{
					if(upperBound == -1) upperBound = i;
				}
			}
			
			//Find the right bound.
			for(int i = x + 1; i < Screen.mapHandler.map.length; i++)
			{
				if(Screen.mapHandler.map[i][y] == 1 || Screen.mapHandler.map[i][y] == 2)
				{
					if(rightBound == -1) rightBound = i;
				}
			}
			
			//Find the lower bound.
			lowerBound = y;
			
			//Find the left bound.
			for(int i = x - 1; i > 0; i--)
			{
				if(Screen.mapHandler.map[i][y] == 1 || Screen.mapHandler.map[i][y] == 2)
				{
					if(leftBound == -1) leftBound = i;
				}
			}
			
		} else if(side == 1)
		{
			//Find the upper bound.
			for(int i = y; i > 0; i--)
			{
				if(Screen.mapHandler.map[x + 1][i] == 1 || Screen.mapHandler.map[x + 1][i] == 2)
				{
					if(upperBound == -1) upperBound = i;
				}
			}
			
			//Find the right bound.
			for(int i = x + 1; i < Screen.mapHandler.map.length; i++)
			{
				if(Screen.mapHandler.map[i][y] == 1 || Screen.mapHandler.map[i][y] == 2)
				{
					if(rightBound == -1) rightBound = i;
				}
			}
			
			//Find the lower bound.
			for(int i = y; i < Screen.mapHandler.map[0].length; i++)
			{
				if(Screen.mapHandler.map[x + 1][i] == 1 || Screen.mapHandler.map[x + 1][i] == 2)
				{
					if(lowerBound == -1) lowerBound = i;
				}
			}
			
			//Find the left bound.
			leftBound = x;
			
		} else if(side == 2)
		{
			//Find the upper bound.
			upperBound = y;
			
			//Find the right bound.
			for(int i = x+1; i < Screen.mapHandler.map.length; i++)
			{
				if(Screen.mapHandler.map[i][y] == 1 || Screen.mapHandler.map[i][y] == 2)
				{
					if(rightBound == -1) rightBound = i;
				}
			}
			
			//Find the lower bound.
			for(int i = y + 1; i < Screen.mapHandler.map[0].length; i++)
			{
				if(Screen.mapHandler.map[x][i] == 1 || Screen.mapHandler.map[x][i] == 2)
				{
					if(lowerBound == -1) lowerBound = i;
				}
			}
			
			//Find the left bound.
			for(int i = x-1; i > 0; i--)
			{
				if(Screen.mapHandler.map[i][y] == 1 || Screen.mapHandler.map[i][y] == 2)
				{
					if(leftBound == -1) leftBound = i;
				}
			}
			
		} else if(side == 3)
		{
			//Find the upper bound.
			for(int i = y - 1; i > 0; i--)
			{
				if(Screen.mapHandler.map[x][i] == 1 || Screen.mapHandler.map[x][i] == 2)
				{
					if(upperBound == -1) upperBound = i;
				}
			}
			
			//Find the right bound.
			rightBound = x;
			
			//Find the lower bound.
			for(int i = y; i < Screen.mapHandler.map[0].length; i++)
			{
				if(Screen.mapHandler.map[x + 1][i] == 1 || Screen.mapHandler.map[x + 1][i] == 2)
				{
					if(lowerBound == -1) lowerBound = i;
				}
			}
			
			//Find the left bound.
			for(int i = x - 1; i > 0; i--)
			{
				if(Screen.mapHandler.map[i][y] == 1 || Screen.mapHandler.map[i][y] == 2)
				{
					if(leftBound == -1) leftBound = i;
				}
			}
			
		}
		
		
		
		
		return new int[] {upperBound, rightBound, lowerBound, leftBound};

	}
	
	/**Generates a new room in the dungeon.
	 * 
	 * @param x :X position of the room generation is based off of.(door)
	 * @param y :Y position of the room generation is based off of.(door)
	 * @param side :Side the generation base in reletive of other rooms.
	 */
	public static void generateRoom(int x, int y, int side)
	{
		int xPlus = 0, xMinus = 0, yPlus = 0, yMinus = 0;
		Random rand = new Random();
		
		int[] bounds = getRoomBounds(x, y, side);
		
		if(bounds[1] - x > 0) xPlus = rand.nextInt(bounds[1] - x);
		if(x - bounds[3] > 0) xMinus = rand.nextInt(x - bounds[3]);
		if(y - bounds[0] > 0) yMinus = rand.nextInt(y - bounds[0]);
		if(bounds[2] - y > 0) yPlus = rand.nextInt(bounds[2] - y);
		
		int xStart = x - xMinus, yStart = y - yMinus, width = xMinus + xPlus, height = yMinus + yPlus;
		
		if(xStart < 0) Screen.mapHandler.pushMap(1, xStart * -1);
		if(yStart < 0) Screen.mapHandler.pushMap(2, yStart * -1);
		if(xStart + width > Screen.mapHandler.map.length) Screen.mapHandler.extendMap(1, (xStart + width) - Screen.mapHandler.map.length);
		if(yStart + height > Screen.mapHandler.map[0].length) Screen.mapHandler.extendMap(2, (yStart + height) - Screen.mapHandler.map[0].length);
		
		for(int parX = 0; parX < width; parX++)
		{
			for(int parY = 0; parY < height; parY++)
			{
				if(parX == 0 || parY == 0 ||parX == width - 1 || parY == height - 1)
				{
					Screen.mapHandler.map[xStart + parX][yStart + parY] = 1;
				}else {
					Screen.mapHandler.map[xStart + parX][yStart + parY] = 0;
				}
			}
		}
		Screen.mapHandler.map[x][y] = 2;
		doorPlacer(new Point(x, y), xStart, yStart, width, height);
	}
	
	public static void doorPlacer(Point existingDoor, int roomX, int roomY, int roomWidth, int roomHeight)
	{
		Random rand = new Random();
		boolean side0 = true, side1 = true, side2 = true, side3 = true;
		
		if(existingDoor.x == roomX) {
			side3 = false;
		}else if ( existingDoor.x == roomX + roomWidth)
		{
			side1 = false;
		}else if(existingDoor.y == roomY)
		{
			side0 = false;
		}else if(existingDoor.y == roomY + roomHeight)
		{
			side2 = false;
		}
		
		if(side0)
		{
			if(rand.nextInt(100) <= 10) {
				Screen.mapHandler.map[roomX + rand.nextInt(roomWidth)][roomY] = 2;
			}
		}
		
		if(side1 && rand.nextInt(100) <= 10)
		{
			Screen.mapHandler.map[roomX + roomWidth][roomY + rand.nextInt(roomHeight)] = 2;
		}
		if(side2 && rand.nextInt(100) <=10)
		{
			Screen.mapHandler.map[roomX + rand.nextInt(roomWidth)][roomY + roomWidth] = 2;
		}
		if(side3 && rand.nextInt(100) <=10)
		{
			Screen.mapHandler.map[roomX][roomY + rand.nextInt(roomHeight)] = 2;
		}
	}

}
