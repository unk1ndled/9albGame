package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed;
	public boolean upLastPressed, downLastPressed, leftLastPressed, rightLastPressed;
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W)
		{
			upPressed = true;
			upLastPressed = false;
			downLastPressed = false;
			leftLastPressed = false;
			rightLastPressed = false;



		}
		if (code == KeyEvent.VK_S)
		{
			downPressed = true;
			upLastPressed = false;
			downLastPressed = false;
			leftLastPressed = false;
			rightLastPressed = false;

		}
		if (code == KeyEvent.VK_A)
		{
			leftPressed = true;
			upLastPressed = false;
			downLastPressed = false;
			leftLastPressed = false;
			rightLastPressed = false;
		}
		if (code == KeyEvent.VK_D)
		{
			rightPressed = true;
			upLastPressed = false;
			downLastPressed = false;
			leftLastPressed = false;
			rightLastPressed = false;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
		int code = e.getKeyCode();
	
	if (code == KeyEvent.VK_W)
	{
		upPressed = false;
		upLastPressed = true;
	}
	if (code == KeyEvent.VK_S)
	{
		downPressed = false;
		downLastPressed = true;
	}
	if (code == KeyEvent.VK_A)
	{
		leftPressed = false;
		leftLastPressed = true;

	}
	if (code == KeyEvent.VK_D)
	{
		rightPressed = false;
		rightLastPressed = true;

	}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

}
