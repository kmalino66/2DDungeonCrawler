package net.trizmo.dungeonCrawler;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class MouseHandler implements MouseInputListener{

	Screen screen;
	
	public MouseHandler(Screen screen) {
		this.screen = screen;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(screen.scene == 0)
		{
			if(Screen.menuButtons[0].checkClicked(arg0))
			{
				//TODO Screen.createNewGame();
			}
			if(Screen.menuButtons[1].checkClicked(arg0))
			{
				//TODO Screen.loadGame();
			}
			if(Screen.menuButtons[2].checkClicked(arg0))
			{
				Screen.running = false;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
