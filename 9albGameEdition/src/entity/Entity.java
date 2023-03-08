package entity;
 import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePannel;
public class Entity {
	
	
	GamePannel gp;
	public int worldX,worldY;
	public int speed;
	public boolean isResting = true;

	public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2,restUp,restDown,restLeft,restRight;
	public String direction;
	public int spriteCounter=0;
	public int spriteNum=1;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	public int actionLockCounter;
	public int actiontimer=1;

	
	public Entity(GamePannel gp) {
		this.gp=gp;
	}

	public void setAction() {}
	
	public void update(){
		setAction();
		collisionOn =false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkPlayer(this);
		
		//COLLISION==FALSE -->PLAYER MOVE
		if((collisionOn == false)&&(!isResting)) {
			switch(direction) {
			case "up" : worldY -= speed; break;
			case "down" : worldY += speed; break;
			case "left" : worldX -= speed; break;
			case "right" : worldX += speed; break;
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
		

		}if(collisionOn == true) {
			isResting=true;
		}
		

		
		}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image=null;

		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		//absolute position of a tile = screen center's absolute position + the distance between it and the tile (screenX=player.screenX)
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if( worldX + gp.tileSize > gp.player.worldX -gp.player.screenX &&
			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			
			

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
		
			
					g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
				}
		
			
		}
		
}
