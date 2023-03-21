package tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePannel;

public class Map extends TileManager{
	
	public BufferedImage mapPIC;
	public BufferedImage characFace;

	public Boolean miniMapOn = true ;
	


	public Map(GamePannel gp)  {
		super(gp);
		
		try {
			mapPIC=ImageIO.read(getClass().getResourceAsStream("/titleScreen/miniMapImage.png"));
			characFace=ImageIO.read(getClass().getResourceAsStream("/titleScreen/ine_facepng.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void drawMiniMap(Graphics2D g2) {
		if(miniMapOn) {
			
			
			int scale =2;
			
			int width = scale * 102;
			int height = scale * 102;
			int x = (gp.screenWidth - width -25);
			int y = (gp.screenHeight - height -25);;
			
			int squareX = scale *((gp.player.worldX-48)/gp.tileSize);
			int squareY = scale *((gp.player.worldY-48)/gp.tileSize);
			int squarewidth = scale * 5;
			int squareheight =scale * 5;			
			
			g2.drawImage(mapPIC, x, y, width, height, gp);
			
			
			g2.drawImage(characFace, x + squareX -(squarewidth/2), y + squareY -(squareheight/2), squarewidth, squareheight, gp);
		}
	}
	
	
	
	
	
	

}
