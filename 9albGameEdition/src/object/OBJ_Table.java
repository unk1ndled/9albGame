package object;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePannel;

public class OBJ_Table extends SuperObject {
	

	public OBJ_Table() {
		solidArea.width=500;
		solidArea.height=80;
		name = "Table";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Table02.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}

		
		collision = true;
		
		//you can change the solid area for each object or keep the default values from superobject

		
		
	}
	
	@Override
	public void draw(Graphics2D g2, GamePannel gp) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		//absolute position of a tile = screen center's absolute position + the distance between it and the tile (screenX=player.screenX)
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if( worldX +500+ gp.tileSize > gp.player.worldX -gp.player.screenX &&
			worldX - gp.tileSize -500 < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize+180 > gp.player.worldY - gp.player.screenY &&
			worldY - gp.tileSize-180 < gp.player.worldY + gp.player.screenY) {
			
			g2.drawImage(image,screenX,screenY,500,108,null);
		}
		
		//check if collison ktkhdm f tile kamla 
	}
	
}
