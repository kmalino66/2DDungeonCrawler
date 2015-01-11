package net.trizmo.dungeonCrawler.graphics;

public class TypeBox{

	private String text;
	private int x, y, width, height;
	private boolean active;
	
	public TypeBox(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean isActive()
	{
		return active;
	}
	
	
}
