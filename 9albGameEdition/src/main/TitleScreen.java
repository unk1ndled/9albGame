package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TitleScreen {
	
	public BufferedImage mainImage;
	public BufferedImage spacebar;
	
	
	int timer =0;
	
	public TitleScreen() {
		try {
			mainImage = ImageIO.read(getClass().getResourceAsStream("/titleScreen/Desktop - 28.png"));
			spacebar = ImageIO.read(getClass().getResourceAsStream("/titleScreen/press spacebar.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void draw(Graphics2D g2, GamePannel gp) {
			
			g2.drawImage(mainImage,0,0,gp.screenWidth,gp.screenHeight,null);
			
			if (timer>=28 && timer<=100) {
				
			g2.drawImage(spacebar,239,411,289,20,null);
			
			if (timer==100) {timer=0;}
			}
			timer++;
	}
}
