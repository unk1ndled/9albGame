package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePannel extends JPanel implements Runnable{
	//Screen settings
	final int originalTileSize = 16;
	final int scale = 3;
	
	public final int tileSize=originalTileSize*scale; //48*48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	
	int FPS=60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this,keyH);
	
	
	int playerX=100;
	int playerY=100;
	int playerSpeed=3;
	
    static int frames = 0 ;
    static int updates = 0;
    static long timer = 0;
	
	
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
			timer =+ (currentTime - lastTime );
			lastTime = currentTime;
			
			if (delta>=1) 
			{
				//Update info about the entities
				update();
                updates++;
				//Draw using updated info
				// repaint is how we call paint component
				repaint();
				frames++;
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
		
		tileM.draw(g2);
		
		player.draw(g2);
	
	    g2.dispose();
	
	}

}

