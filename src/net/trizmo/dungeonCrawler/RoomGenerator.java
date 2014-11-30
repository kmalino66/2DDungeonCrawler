package net.trizmo.dungeonCrawler;

public class RoomGenerator {

	public static int[] getRoomBounds(int x, int y, int side)
	{
		int rightBound = -1, leftBound = -1, upperBound = -1, lowerBound = -1;

		if(side == 0)
		{
			//Find the upper bound.
			for(int i = y - 1; i > 0; i--)
			{
				if(Screen.mapHandler.map[x][i] == 1 || Screen.mapHandler.map[x + 1][i] == 2)
				{
					if(upperBound == -1) upperBound = i;
				}
			}
			
			//Find the right bound.
			for(int i = x + 1; i < Screen.mapHandler.map.length; i++)
			{
				if(Screen.mapHandler.map[i][y] == 1 || Screen.mapHandler.map[i + 1][y + 1] == 2)
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
				if(Screen.mapHandler.map[i][y] == 1 || Screen.mapHandler.map[i + 1][y + 1] == 2)
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
				if(Screen.mapHandler.map[i][y] == 1 || Screen.mapHandler.map[i + 1][y + 1] == 2)
				{
					if(rightBound == -1) rightBound = i;
				}
			}
			
			//Find the lower bound.
			for(int i = y + 1; i < Screen.mapHandler.map[0].length; i++)
			{
				if(Screen.mapHandler.map[x][i] == 1 || Screen.mapHandler.map[x + 1][i] == 2)
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
				if(Screen.mapHandler.map[x][i] == 1 || Screen.mapHandler.map[x + 1][i] == 2)
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
	
	public void generateRoom(int x, int y, int side)
	{
		getRoomBounds(x, y, side);
	}

}
