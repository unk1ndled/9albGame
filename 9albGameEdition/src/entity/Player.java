package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePannel;
import main.KeyHandler;

public class Player extends Entity{
	GamePannel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	int hasObject = 0;
	
	
	public Player(GamePannel gp, KeyHandler keyH)
	{
		this.gp=gp;
		this.keyH=keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea =new Rectangle();
		//solidArea.x= 8;
		//solidArea.y=16;
		solidArea.x= 10;
		solidArea.y=20;
		
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		solidArea.width=28;
		solidArea.height=28; 
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues()
	{
		worldX=gp.tileSize*45 -(gp.tileSize/2);//xstarting position
		worldY=gp.tileSize*100 -(gp.tileSize/2);//y starting position
		speed = 8;
		direction="down";
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
		//System.out.println("X : "+ worldX/48 + "   y : "+ worldY/48 );//TRUUUUUUE
	}
}
