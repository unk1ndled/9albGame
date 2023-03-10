package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

	GamePannel gp;
	Font arial_40;
	
	public UI(GamePannel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 20);
		
	}
	
	public void draw (Graphics2D g2) {
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		g2.drawString("Imposters caught : ", 50, 50);
	}
	
	
}
