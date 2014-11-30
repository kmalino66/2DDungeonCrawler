package net.trizmo.dungeonCrawler.weapons;

import java.util.Random;

public class Weapon {

	private String weaponName, damageRoll, weaponType;
	
	/**
	 * Main constructor to create a new weapon.
	 * @param weaponName: The name of the weapon.
	 * @param weaponType: The type of weapon to be made.
	 * @param damageRoll: Description of the rolls '<number>d<maxRoll>
	 * @param weaponHealth: The health the weapon has at the time.
	 * @param maxWeaponHealth: The max amount of health the weapon can have.
	 */
	public Weapon(String weaponName, String weaponType, String damageRoll, int weaponHealth, int maxWeaponHealth)
	{
		this.weaponName = weaponName;
		this.damageRoll = damageRoll;
		this.weaponType = weaponType;
	}
	
	/**
	 * Returns how much damage the weapon does for this.
	 * @param requiredAttackRoll: 
	 * @param modifiers
	 * @return
	 */
	public int getDamageDealt(int requiredAttackRoll, int attackModifiers, int damageModifiers)
	{
		Random rand = new Random();
		int damage = 0;
		
		int par1 = rand.nextInt(20);
		if(par1 + attackModifiers > requiredAttackRoll)
		{
			String[] par2String = damageRoll.split("d");
			int par1RollAmount = Integer.parseInt(par2String[0]);
			int par1DamageAmount = Integer.parseInt(par2String[1]);
			
			for(int i = 0; i < par1RollAmount; i++)
			{
				damage += rand.nextInt(par1DamageAmount);
			}
		}
		
		return damage + damageModifiers;
	}
	
	public String getWeaponName()
	{
		return weaponName;
	}
	
	public String getWeaponType()
	{
		return weaponType;
	}
}
