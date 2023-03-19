package object;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePannel;

public class OBJ_Wanted extends SuperObject {

	public OBJ_Wanted() {
		name = "Tutorial";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/deadOrAlive.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		collision = false;
		
	}
	
	@Override
	public void draw(Graphics2D g2, GamePannel gp) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		//absolute position of a tile = screen center's absolute position + the distance between it and the tile (screenX=player.screenX)
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if( worldX +621+ gp.tileSize > gp.player.worldX -gp.player.screenX &&
			worldX - gp.tileSize -621 < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize+428 > gp.player.worldY - gp.player.screenY &&
			worldY - gp.tileSize-428 < gp.player.worldY + gp.player.screenY) {
			
			g2.drawImage(image,screenX,screenY,878/10,1094/10,null);
		}
		
		//check if collison ktkhdm f tile kamla 
	}
}
