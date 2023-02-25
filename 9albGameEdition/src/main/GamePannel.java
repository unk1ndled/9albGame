package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePannel extends JPanel implements Runnable{
	//Screen settings
	final int originalTileSize = 16;
	final int scale = 3;
	
	public final int tileSize=originalTileSize*scale; //48*48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	
	
	int FPS=60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this,keyH);
	
	
	int playerX=100;
	int playerY=100;
	int playerSpeed=3;
	
	
	public GamePannel()
	{
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
	    this.setBackground(Color.black);
	    this.setDoubleBuffered(true);
	    this.addKeyListener(keyH);
	    this.setFocusable(true);
	}
	
	public void startGameThread()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	public void run() 
	{
		double drawInterval=1000000000/FPS;
		double delta=0;long lastTime = System.nanoTime();
		while(gameThread != null)
		{
			
			long currentTime = System.nanoTime();
			
			delta+= (currentTime - lastTime ) / drawInterval;
			
			lastTime = currentTime;
			
			if (delta>=1) 
			{
				//Update info about the entities
				update();
				//Draw using updated info
				// repaint is how we call paint component
				repaint();
				delta--;
			}

		}
	}
	public void update()
	{
		player.update();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
	
		player.draw(g2);
	
	    g2.dispose();
	
	}

}

