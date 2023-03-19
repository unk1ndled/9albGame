package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	GamePannel gp;
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	public boolean upLastPressed, downLastPressed, leftLastPressed, rightLastPressed;
	
	public boolean interactPressed;
	
	public KeyHandler(GamePannel gp) {
		this.gp=gp;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		//titlestate controls
		
		if(gp.gameState == gp.titleState) {
			if(code == KeyEvent.VK_SPACE) {
				
				gp.gameState = gp.playState;
			}
			
		}
		
		//gamestate controls
		
		if (gp.gameState==gp.playState) {
			
			if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
			{
				upPressed = true;
				upLastPressed = false;
				downLastPressed = false;
				leftLastPressed = false;
				rightLastPressed = false;
				
			}
			if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
			{
				downPressed = true;
				upLastPressed = false;
				downLastPressed = false;
				leftLastPressed = false;
				rightLastPressed = false;

			}
			if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
			{
				leftPressed = true;
				upLastPressed = false;
				downLastPressed = false;
				leftLastPressed = false;
				rightLastPressed = false;
			}
			if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
			{
				rightPressed = true;
				upLastPressed = false;
				downLastPressed = false;
				leftLastPressed = false;
				rightLastPressed = false;

			}
			
			if (code == KeyEvent.VK_P)
			{
					gp.gameState=gp.pauseState;
				

			}
			
			if (code == KeyEvent.VK_E)
			{
				this.interactPressed=true;

			}
			
		}
		//pausestate controls
		
		else if (gp.gameState==gp.pauseState) {
			
			if (code == KeyEvent.VK_P)
			{
					gp.gameState=gp.playState;
				

			}
			
		}

		//dialogue controls

		else if (gp.gameState==gp.dialogueState) {
			
			if (code == KeyEvent.VK_E)
			{
					gp.gameState=gp.playState;
				

			}
		}
		
		

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
		int code = e.getKeyCode();
	
	if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
	{
		upPressed = false;
		upLastPressed = true;
	}
	if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
	{
		downPressed = false;
		downLastPressed = true;
	}
	if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
	{
		leftPressed = false;
		leftLastPressed = true;

	}
	if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
	{
		rightPressed = false;
		rightLastPressed = true;

	}
	if (code == KeyEvent.VK_E)
	{
		interactPressed = false;

	}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

}
