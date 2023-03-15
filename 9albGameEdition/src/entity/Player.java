package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePannel;
import main.KeyHandler;

public class Player extends Entity{
	
	KeyHandler keyH;
	public final int screenX;
	public final int screenY;
	int hasObject = 0;
	int npcIndex=999;
	
	public int impostersCaught = 0;
	

	
	
	public Player(GamePannel gp, KeyHandler keyH)
	{
		super(gp);
		
		this.keyH=keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea =new Rectangle();
		//solidArea.x= 8;
		//solidArea.y=16;
		
		solidArea.x= 10;
		solidArea.y= 26;
		
		solidAreaDefaultX=solidArea.x;
		solidAreaDefaultY=solidArea.y;
		
		solidArea.width= 24;
		solidArea.height= 20; 
		
		
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues()
	{
		worldX=gp.tileSize*52 -(gp.tileSize/2);//xstarting position
		worldY=gp.tileSize*92 -(gp.tileSize/2);//y starting position
		speed = 6;
		direction="up";
	}
	
	public void getPlayerImage()
	{
		try{
			up1= ImageIO.read(getClass().getResourceAsStream("/player/ine_up_right.png"));
			up2= ImageIO.read(getClass().getResourceAsStream("/player/ine_up_left.png"));
			down1= ImageIO.read(getClass().getResourceAsStream("/player/ine_down_left.png"));
		    down2= ImageIO.read(getClass().getResourceAsStream("/player/ine_down_right.png"));
			left1= ImageIO.read(getClass().getResourceAsStream("/player/ine_left_1.png"));
			left2= ImageIO.read(getClass().getResourceAsStream("/player/ine_left_2.png"));
			right1= ImageIO.read(getClass().getResourceAsStream("/player/ine_right_1.png"));
			right2= ImageIO.read(getClass().getResourceAsStream("/player/ine_right_2.png"));
			restDown=ImageIO.read(getClass().getResourceAsStream("/player/ine_down_rest.png"));
			restUp=ImageIO.read(getClass().getResourceAsStream("/player/ine_up_rest.png"));
			restLeft=ImageIO.read(getClass().getResourceAsStream("/player/ine_rest_left.png"));
			restRight=ImageIO.read(getClass().getResourceAsStream("/player/ine_rest_right.png"));

			/*
			up1= ImageIO.read(getClass().getResourceAsStream("/chat/chat6.png"));
			up2= ImageIO.read(getClass().getResourceAsStream("/chat/chat4.png"));
			down1= ImageIO.read(getClass().getResourceAsStream("/chat/chat1.png"));
		    down2= ImageIO.read(getClass().getResourceAsStream("/chat/chat9.png"));
			left1= ImageIO.read(getClass().getResourceAsStream("/chat/chat7.png"));
			left2= ImageIO.read(getClass().getResourceAsStream("/chat/chat2.png"));
			right1= ImageIO.read(getClass().getResourceAsStream("/chat/chat8.png"));
			right2= ImageIO.read(getClass().getResourceAsStream("/chat/chat3.png"));
			restDown=ImageIO.read(getClass().getResourceAsStream("/chat/chat12.png"));
			restUp=ImageIO.read(getClass().getResourceAsStream("/chat/chat5.png"));
			restLeft=ImageIO.read(getClass().getResourceAsStream("/chat/chat10.png"));
			restRight=ImageIO.read(getClass().getResourceAsStream("/chat/chat11.png"));
			 
			*/
			
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void update()
	{
		
		if ((keyH.upPressed==true)||(keyH.downPressed==true)||(keyH.leftPressed==true)||(keyH.rightPressed==true)) 
		{
			this.isResting=false;
			if (keyH.upPressed==true)
			{
				direction="up";
			}
			if (keyH.downPressed==true)
			{
				direction="down";
			}
			if (keyH.leftPressed==true)
			{
				direction="left";
			}
			if (keyH.rightPressed==true)
			{
				direction="right";
			}
			
			//CHECK COLLISION
			collisionOn= false;
			gp.cChecker.checkTile(this);
			
			//CHECK OBJECT COLLISION 
			int objIndex = gp.cChecker.checkObject(this, true);
			interactWithObject(objIndex);
			
			//CHECK NPC COLLISION
			npcIndex = gp.cChecker.checkEntity(this, gp.npc);

			
			//COLLISION==FALSE -->PLAYER MOVE
			if(collisionOn == false) {
				switch(direction) {
				case "up" : worldY -= speed; break;
				case "down" : worldY += speed; break;
				case "left" : worldX -= speed; break;
				case "right" : worldX += speed; break;
				}
				
			}
			
			spriteCounter++;
			if (spriteCounter>6)
			{
				if (spriteNum==1)
	            {
	            	spriteNum=2;
				}
				else if (spriteNum==2)
	            {
	            	spriteNum=1;
				}
				spriteCounter=0;
	  
			}
	
		}
		else {
			if ((keyH.upLastPressed==true)||(keyH.downLastPressed==true)||(keyH.leftLastPressed==true)||(keyH.rightLastPressed==true))
			{
				
				this.isResting=true;
				
				if (keyH.rightLastPressed==true)
				{
					direction="right";

				}
				if (keyH.downLastPressed==true)
				{
					direction="down";

				}
				
				if (keyH.upLastPressed==true)
				{
					direction="up";

				}
				if (keyH.leftLastPressed==true)
				{
					direction="left";

				}
			}
		}
		npcIndex =gp.cChecker.checkEntityforInteraction(this, gp.npc);
		interactWithNpc(npcIndex);
		
	}
	
	public void interactWithObject(int i) {
		
		if(i != 999) {
			String objectName = gp.obj[i].name;
			switch (objectName) {
			case "Coffee":
				System.out.print("you obtained BlackTux");
				gp.obj[i] = null;
				break;
			case "Object":
				//hna kadir interaction maa object 
				break;
			}
		}
		
	}
	
	public void interactWithNpc(int npcindex) {
		
		if (keyH.interactPressed) {
			if(npcindex != 999) {
				gp.gameState=gp.dialogueState;
				gp.npc[npcindex].speak();
				
			}
		}
	}
	
	
	public void draw(Graphics2D g2)
	{
       // g2.setColor(Color.white);
        //g2.fillRect(x,y,gp.tileSize,gp.tileSize);
		BufferedImage image=null;
		if (!(isResting)) {
		switch(direction)
		{
		case "up":
			if(spriteNum==1) 
			{
				image = up1;
			}
			if (spriteNum==2) 
			{
				image = up2;
			}
			  break;
		case "down":
			if(spriteNum==1) 
			{
				image = down1;
			}
			if (spriteNum==2) 
			{
				image = down2;
			}
			  break;
		case "left":
			if(spriteNum==1) 
			{
				image = left1;
			}
			if (spriteNum==2) 
			{
				image = left2;
			}
			  break;
		case "right":
			if(spriteNum==1) 
			{
				image = right1;
			}
			if (spriteNum==2) 
			{
				image = right2;
			}
			  break;	  
		
		}}
		else {

			switch(direction)
			{
			case "up":
				image = restUp;
				  break;
			case "down":
				image = restDown;
				  break;
			case "left":
				image = restLeft;
				  break;
			case "right":
				image = restRight;
				  break;	  
			
			}
			
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		System.out.println("X : "+ worldX/48 + "   y : "+ worldY/48 );//TRUUUUUUE
	}
}
