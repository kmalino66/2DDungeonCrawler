package net.trizmo.dungeonCrawler.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import net.trizmo.dungeonCrawler.MessageHandler;
import net.trizmo.dungeonCrawler.Screen;

public class MenuButton {

	private int x, y, width, height;
	private String textureName, text;
	private Color textColor;
	private boolean visible = true;
	private Font idealFont;

	public MenuButton(int x, int y, int width, int height, String textureName, Color textColor, String text){
		this(x, y, width, height);
		this.textureName = textureName;
		this.textColor = textColor;
		this.text = text;
	}

	public MenuButton(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void drawComponent(Graphics g)
	{
		if(visible) 
		{
			Font font = new Font("SansSerif", Font.PLAIN, height);
			g.setFont(font);
			FontMetrics fm = g.getFontMetrics(); 

			while(fm.stringWidth(text) > width)
			{
				int par1 = (int)(font.getSize()) - 1;
				font = new Font("SansSerif", Font.PLAIN, par1);
				g.setFont(font);
				fm = g.getFontMetrics();
			}
			ImageIcon textureImage = new ImageIcon("src/net/trizmo/dungeonCrawler/res/" + textureName + ".png");
			g.setFont(idealFont);
			g.setColor(textColor);
			fm = g.getFontMetrics();
			g.drawImage(textureImage.getImage(), x, y, width, height, null);
			g.drawString(text, (int) ((x + (width / 2)) - fm.stringWidth(text) / 2), (y + (height / 2)) + (fm.getMaxAscent()/ 2));

			g.setFont(Screen.standardFont);
			g.setColor(Color.BLACK);
		}
	}

	public void changeVisibility()
	{
		if(visible) visible = false;
		if(!visible) visible = true;
	}
	
	public boolean checkClicked(MouseEvent e)
	{
		Rectangle rect = new Rectangle(x, y, width, height);
		return rect.contains(e.getPoint());
	}

}
