package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class UI {

	GamePannel gp;
	Font arial_40;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.0");
	
	public UI(GamePannel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 20);
		
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw (Graphics2D g2) {
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		g2.drawString("Imposters caught : ", 50, 50);
		
		//TIME
		playTime +=(double)1/60;
		g2.drawString("Time : "+dFormat.format(playTime),gp.tileSize , 65);
		
		//MESSAGE
		if(messageOn == true) {
			g2.drawString(message, 0, 0);
			
			messageCounter++;
			
			if(messageCounter > 120) {
				messageCounter = 0;
				messageOn = false;
			}
		}
	}
	
	
}
