package net.trizmo.dungeonCrawler;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import net.trizmo.dungeonCrawler.graphics.GraphicsManager;
import net.trizmo.dungeonCrawler.graphics.MenuButton;
import net.trizmo.dungeonCrawler.map.MapHandler;

public class Screen extends JPanel implements Runnable{

	public static MapHandler mapHandler;

	private static final long serialVersionUID = 1L;

	public static int width, height, boxSize;
	public static int[] screenPosBounds;
	public int scene = 0; // Scene values : 0 = Main SCreen, 100 = playing screen.
	public static Player player = null;
	public static Font standardFont;

	public static MenuButton[] menuButtons = null;
	public static Graphics graph;

	Thread thread = new Thread(this);
	public static Frame frame;
	public static boolean running = true;

	public Screen(Frame frame) {

		Screen.frame = frame; 
		Screen.frame.addMouseListener(new MouseHandler(this));
		
		width = frame.getWidth();
		height = frame.getHeight();

		if(height < width)
		{
			boxSize = width / 20;
		}else {
			boxSize = height / 20;
		}
		
		screenPosBounds = new int[]{ (int)((width) / boxSize) + 2, (int)((height) / boxSize) + 2};
		
		graph = this.getGraphics();
		thread.start();
	}

	/**
	 * Move all things coordinate bound.
	 * @param side 1=x 2=y
	 * @param amount
	 */
	public static void pushItems(int side, int amount)
	{
		if(player != null && player.isAlive())
		{
			player.move(side, amount);
		}
	}

	public void run() {
		System.out.println("j");

		startProgram();

		while(running)
		{


			repaint();
		}
		
		FileManager.saveGame();
		System.exit(0);
	}

	public void startProgram()
	{
		GraphicsManager.sceneChanged(-1, 0);
		
	}

	public void changeScene(int newScene)
	{
		GraphicsManager.sceneChanged(scene, newScene);
		scene = newScene;
	}

	public void paintComponent(Graphics g)
	{
		g.clearRect(0, 0, width, height);

		g.drawRect(0, 0, 50, 50);
		if(scene == 0) GraphicsManager.drawScene0(g);
	}

	public static Graphics retrieveCurrentGraphics()
	{
		return Screen.frame.getGraphics();
	}
}
