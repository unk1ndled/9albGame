package main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePannel extends JPanel implements Runnable{
	//Screen settings
	final int originalTileSize = 16;//16
	final int scale = 3;
	
	public final int tileSize=originalTileSize*scale; //48*48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;//768 pixexls
	public final int screenHeight = tileSize * maxScreenRow;//576 pixels
	
	//WORLD SETTINGS
	public final int maxWorldCol = 106;
	public final int maxWorldRow = 106;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int wortldHeight = tileSize * maxWorldRow;
	
	
	//FPS
	int FPS=60;
	
	//sys
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this,keyH);
	
	// entity/objects
	public SuperObject obj[] = new SuperObject[100];//nmbr of diplayed objects of at same time
	public Entity npc[] = new Entity[10];
	
	
    static int frames = 0 ;
    static int updates = 0;
    static long timer = 0;
	
    //game state
    public int gameState;
    public final int playState =1;
    public final int pauseState =2;  

    
    
    
	public GamePannel()
	{
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
	    this.setBackground(Color.black);
	    this.setDoubleBuffered(true);
	    this.addKeyListener(keyH);
	    this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
		aSetter.setNPC();
		gameState = playState;
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
		if (gameState==playState) {
		//player	
		player.update();
		
		//NPC
		for (int i = 0; i < npc.length; i++) {
			if (npc[i] != null){
				npc[i].update();
			}
			
		}
		
		}
		if (gameState == pauseState) {
		//do nothing
		}
		

		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//tile
		tileM.draw(g2);
		
		//object
		for(int i=0; i < obj.length; i++) {
			if(obj[i] !=null) {
				obj[i].draw(g2, this);
			}
		}
		
		//NPC
		for (int i = 0; i < npc.length; i++) {
			if (this.npc[i] != null) {
			    this.npc[i].draw(g2);
			}
			
		}
		
		
		//player
		player.draw(g2);
	
	    g2.dispose();
	
	}

}

