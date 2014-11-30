
package net.trizmo.dungeonCrawler;

import java.util.Random;

/**
 * Main class for the player. Holds all the information.
 * @author Kyle
 *
 */
public class Player {

	private String characterName, characterType;
	@SuppressWarnings("unused")
	private int health, maxHealth, strength, coordination, dextarity, wisdom, charisma, xp, level;
	
	//Records the different XP levels for the max xp until leveling up.
	public final static int[] levels = new int[] { 1000, 5000, 15000, 35000, 75000 };
	
	private boolean alive;
	
	/**
	 * Main constructor for the player.  Creates the information and character stats for the player.
	 * @param characterName: Name of the character.
	 * @param characterType: A string value of the characters type.
	 */
	public Player(String characterName, String characterType)
	{
		Random rand = new Random();
		this.characterName = characterName;
		this.characterType = characterType;
		
		int maxHealth01 = rand.nextInt(20);
		if(maxHealth01 < 10) maxHealth01 += 10;
		
		this.maxHealth = maxHealth01;
		
		strength = rand.nextInt(20);
		coordination = rand.nextInt(20);
		dextarity = rand.nextInt(20);
		wisdom = rand.nextInt(20);
		charisma = rand.nextInt(20);
		alive = true;
		health = maxHealth;
	}
	
	/**
	 * Changes the amount of health that the player has.
	 * @param delta: Amount to change the helth by.  Positive increases health, negative decreases health.
	 */
	public void changeHealth(int delta)
	{
		if(health + delta > maxHealth)
		{
			health = maxHealth;
		}else if(health + delta < 0)
		{
			alive = false;
		}else {
			health += maxHealth;
		}
	}
	
	/**
	 * Changes the amount of XP the player has.
	 * @param deltaXP: Amount to change the XP by.
	 */
	public void addXP(int deltaXP)
	{
		xp += deltaXP;
	}
	
	/**
	 * Gets the strength value the player has.
	 * @return: strenth
	 */
	public int getStrength()
	{
		return strength;
	}
	
	/**
	 * Gets the coordination value the player has.
	 * @return: coordination
	 */
	public int getCoordination()
	{
		return coordination;
	}
	
	public int getDextarity()
	{
		return dextarity;
	}
	
	public int getWisdom()
	{
		return wisdom;
	}
	
	public int getCharisma()
	{
		return charisma;
	}
	
	/**
	 * Gets if the player is alive
	 * @return: true = alive, false = dead.
	 */
	public boolean isAlive()
	{
		return alive;
	}
	
	public String getCharacterName()
	{
		return characterName;
	}
	
	public String getCharacterType()
	{
		return characterType;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	/**
	 * This will be called when the player is moved.  Deals with the methods that need to be called when this happens.
	 * @param newXPos: The new X-position of the player.
	 * @param newYPos: The new Y-position of the player.
	 */
	public void playerMoved(int newXPos, int newYPos)
	{
		if(Screen.mapHandler.map[newXPos][newYPos] == 2)
		{
			int side;
			if(Screen.mapHandler.map[newXPos][newYPos - 1] == -1) side = 0;
			if(Screen.mapHandler.map[newXPos + 1][newYPos] == -1) side = 1;
			if(Screen.mapHandler.map[newXPos][newYPos + 1] == -1) side = 2;
			if(Screen.mapHandler.map[newXPos - 1][newYPos] == -1) side = 3;
			
			
			//TODO put roomGeneration method here.
		}
	}
}
