package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TitleScreen {
	public BufferedImage image;

	public TitleScreen() {
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/titleScreen/InptAdventure.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void draw(Graphics2D g2, GamePannel gp) {
			
			g2.drawImage(image,0,0,gp.screenWidth,gp.screenHeight,null);

	}
}
