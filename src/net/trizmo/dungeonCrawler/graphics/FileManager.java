package net.trizmo.dungeonCrawler.graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

import net.trizmo.dungeonCrawler.Player;
import net.trizmo.dungeonCrawler.Screen;

public class FileManager {

	static Scanner inputScanner;
	/**
	 * Loads the information needed from the save file.
	 */
	public static void loadSave()
	{
		//Need to setup the player and map here
		try {
			inputScanner = new Scanner(new InputStreamReader(new FileInputStream("net/trizmo/dungeonCrawler/res/SaveFile.save")));
		
			int mapY = 0, mapX = 0;
			String[] rawCharacterLine = inputScanner.nextLine().split(":");
			
			Screen.player = new Player(rawCharacterLine[0], rawCharacterLine[1], Integer.parseInt(rawCharacterLine[2]), Integer.parseInt(rawCharacterLine[3]), Integer.parseInt(rawCharacterLine[4]), Integer.parseInt(rawCharacterLine[5]), 
					Integer.parseInt(rawCharacterLine[6]), Integer.parseInt(rawCharacterLine[7]), Integer.parseInt(rawCharacterLine[8]), Integer.parseInt(rawCharacterLine[9]), Integer.parseInt(rawCharacterLine[10]), Integer.parseInt(rawCharacterLine[11]), 
					Integer.parseInt(rawCharacterLine[12]));
			
			String[] mapSizeRaw = inputScanner.nextLine().split(",");
			Screen.mapHandler.map = new int[Integer.parseInt(mapSizeRaw[0])][Integer.parseInt(mapSizeRaw[1])];
			
			while(inputScanner.hasNext())
			{
				String[] mapRawData = inputScanner.nextLine().split(",");
				
				for( int i = 0; i < mapRawData.length; i++)
				{
					int blockId = Integer.parseInt(mapRawData[i].split(":")[0]);
					int amount = Integer.parseInt(mapRawData[i].split(":")[1]);
					
					for(int k = 0; k < amount; k++)
					{
						Screen.mapHandler.map[mapX][mapY] = blockId;
						mapX++;
					}
				}
				mapY++;
				
			}
			
			inputScanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}
