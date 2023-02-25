package entity;

import java.awt.Color;
import java.awt.Graphics2D;
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
	
	public Player(GamePannel gp, KeyHandler keyH)
	{
		this.gp=gp;
		this.keyH=keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues()
	{
		worldX=gp.tileSize*0 -(gp.tileSize/2);//xstarting position
		worldY=gp.tileSize*0 -(gp.tileSize/2);//y starting position
		speed = 5;
		direction="down";
	}
	public void getPlayerImage()
	{
		try{
			up1= ImageIO.read(getClass().getResourceAsStream("/player/ye_back_left.png"));
			up2= ImageIO.read(getClass().getResourceAsStream("/player/ye_back_right.png"));
			down1= ImageIO.read(getClass().getResourceAsStream("/player/ye_front_left.png"));
		    down2= ImageIO.read(getClass().getResourceAsStream("/player/ye_front_right.png"));
			left1= ImageIO.read(getClass().getResourceAsStream("/player/ye_side_left.png"));
			left2= ImageIO.read(getClass().getResourceAsStream("/player/ye_side_walk_left.png"));
			right1= ImageIO.read(getClass().getResourceAsStream("/player/ye_side_right.png"));
			right2= ImageIO.read(getClass().getResourceAsStream("/player/ye_side_walk_right.png"));
			restUp=ImageIO.read(getClass().getResourceAsStream("/player/rest1.png"));
			restDown=ImageIO.read(getClass().getResourceAsStream("/player/rest1.png"));
			restLeft=ImageIO.read(getClass().getResourceAsStream("/player/rest1.png"));
			restRight=ImageIO.read(getClass().getResourceAsStream("/player/rest1.png"));


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
				worldY-= speed;
			}
			if (keyH.downPressed==true)
			{
				direction="down";
				worldY+= speed;
			}
			if (keyH.leftPressed==true)
			{
				direction="left";
				worldX-= speed;
			}
			if (keyH.rightPressed==true)
			{
				direction="right";
				worldX+= speed;
			}
			spriteCounter++;
			if (spriteCounter>13)
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
				if (keyH.upLastPressed==true)
				{
					direction="up";

				}
				if (keyH.downLastPressed==true)
				{
					direction="down";

				}
				if (keyH.leftLastPressed==true)
				{
					direction="left";

				}
				if (keyH.rightLastPressed==true)
				{
					direction="right";

				}
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
				image = restUp;

				  break;
			case "left":
				image = restUp;

				  break;
			case "right":
				image = restUp;

				  break;	  
			
			}
			
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
