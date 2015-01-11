package net.trizmo.dungeonCrawler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

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

	public static void saveGame()
	{
		try{
			int cbID = -1, amount = 0;
			File file = new File("net/trizmo/dungeonCrawler/res/SaveFile.save");
			file.delete();
			file.createNewFile();

			PrintWriter printer = new PrintWriter(new FileWriter("net/trizmo/dungeonCrawler/res/SaveFile.save"));

			//Print the information to be saved to the file here.
			String[] playerInfo = Screen.player.getAllPlayerInformation();
			
			for(int i = 0; i < playerInfo.length; i++)
			{
				printer.print(playerInfo[i] + ":");
			}
			
			printer.println();
			
			printer.print(Screen.mapHandler.map.length + "," + Screen.mapHandler.map[0].length);
			
			printer.println();
			
			for(int y = 0; y < Screen.mapHandler.map[0].length; y++)
			{
				for(int x = 0; x < Screen.mapHandler.map.length; x++)
				{
					if(Screen.mapHandler.getBlockFromCoord(x, y) == cbID)
					{
						amount++;
					}else if(cbID == -1)
					{
						cbID = Screen.mapHandler.getBlockFromCoord(x, y);
						amount = 1;
					}else
					{
						printer.print(cbID + ":" + amount + ",");
						cbID = Screen.mapHandler.getBlockFromCoord(x, y);
						amount = 1;
					}
				}
			}

			printer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
