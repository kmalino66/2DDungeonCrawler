
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
	private int health, maxHealth, strength, coordination, dextarity, wisdom, charisma, xp, level, xPos, yPos;

	//Records the different XP levels for the max xp until leveling up.
	public final static int[] levels = new int[] { 1000, 5000, 15000, 35000, 75000 };

	private boolean alive;

	/**
	 * Main constructor for the player.  Creates the information and character stats for the player.
	 * @param characterName: Name of the character.
	 * @param characterType: A string value of the characters type.
	 */
	public Player(String characterName, String characterType, int xPos, int yPos)
	{
		this(characterName, characterType, createMaxHealth(), createMaxHealth(), createStat(), createStat(), createStat(), createStat(), createStat(), 0, 1, xPos, yPos);
	}

	public Player(String characterName, String characterType, int health, int maxHealth, int strength, int coordination, int dextarity, int wisdom, int charisma, int xp, int level, int xPos, int yPos)
	{
		this.characterName = characterName;
		this.characterType = characterType;
		this.health = health;
		this.maxHealth = maxHealth;
		this.strength = strength;
		this.coordination = coordination;
		this.dextarity = dextarity;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.xp = xp;
		this.level = level;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	private static int createMaxHealth()
	{
		Random rand = new Random();
		int maxHealth01 = rand.nextInt(20);
		if(maxHealth01 < 10) maxHealth01 += 10;
		return maxHealth01;
	}

	private static int createStat()
	{
		Random rand = new Random();
		return rand.nextInt(20);
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
			int side = -1;
			if(Screen.mapHandler.map[newXPos][newYPos - 1] == -1) side = 0;
			if(Screen.mapHandler.map[newXPos + 1][newYPos] == -1) side = 1;
			if(Screen.mapHandler.map[newXPos][newYPos + 1] == -1) side = 2;
			if(Screen.mapHandler.map[newXPos - 1][newYPos] == -1) side = 3;


			//TODO put roomGeneration method here.
			if(side != -1)
			{

			}
		}
	}

	public void move(int direction, int amount)
	{
		switch(direction) {
		case 0:
			if(Screen.mapHandler.checkCoordValidPerson(xPos, yPos - amount)) yPos--;
			break;
		case 1:
			if(Screen.mapHandler.checkCoordValidPerson(xPos + amount, yPos)) xPos--;
			break;
		case 2:
			if(Screen.mapHandler.checkCoordValidPerson(xPos, yPos + amount)) yPos++;
			break;
		case 3:
			if(Screen.mapHandler.checkCoordValidPerson(xPos - amount, yPos)) xPos--;
			break;
		}
	}

	public void move(int direction)
	{
		move(direction, 1);
	}
	
	public String[] getAllPlayerInformation()
	{
		return new String[] {characterName, characterType, health + "", maxHealth + "", strength + "", coordination + "", dextarity + "", wisdom + "", charisma + "", xp + "", level + "", xPos + "", yPos + ""};
	}
	
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}


}
