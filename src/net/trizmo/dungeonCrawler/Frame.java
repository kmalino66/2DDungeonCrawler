package net.trizmo.dungeonCrawler;

import javax.swing.JFrame;

/**
 * Main starter class.
 * @author Kyle
 *
 */
public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		/*SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Frame();
			}
		});*/
		new Frame();
	}
	
	public Frame() 
	{
		new JFrame();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("hi");
		this.setLocation(0,0);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
		this.setExtendedState(MAXIMIZED_BOTH);

		Screen screen = new Screen(this);
		this.add(screen);
	}
}
