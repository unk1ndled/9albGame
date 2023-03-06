package object;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePannel;

public class OBJ_Chair extends SuperObject {
	
	public String type;

	public OBJ_Chair(String s) {
		type = s;
		
		solidArea.width=30;
		solidArea.height=20;
		name = "Chair";
		try {
			if(s == "DOWN") {
				image = ImageIO.read(getClass().getResourceAsStream("/objects/Chair01.png"));
			}
			else if(s == "UP") {
				image = ImageIO.read(getClass().getResourceAsStream("/objects/Chair02.png"));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		collision = true;
		
		//you can change the solid area for each object or keep the default values from superobject
		//solidArea.x=80;
		//solidArea.y=80;
		
		
	}
	
	@Override
	public void draw(Graphics2D g2, GamePannel gp) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		//absolute position of a tile = screen center's absolute position + the distance between it and the tile (screenX=player.screenX)
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if( worldX + gp.tileSize > gp.player.worldX -gp.player.screenX &&
			worldX - gp.tileSize  < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			if(this.type == "DOWN") {
				g2.drawImage(image,screenX,screenY,30,48,null);
			}
			else {
				g2.drawImage(image,screenX,screenY+14,30,48,null);
			}
			
		}
		
		//check if collison ktkhdm f tile kamla 
	
	}
}
