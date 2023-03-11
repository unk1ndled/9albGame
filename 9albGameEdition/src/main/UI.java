package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class UI {

	GamePannel gp;
	Graphics2D g2;
	
	Font arial_40;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public String currentDialogue = "";
	
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
		this.g2=g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		
		
		
		if (gp.gameState==gp.playState) {
		//Gamestate stuff
			//TIME
			playTime +=(double)1/60;
			}
		
		
		
		if (gp.gameState==gp.pauseState) {
			//pauseState stuff
			drawPauseScreen();
			}
		
		
		if (gp.gameState==gp.dialogueState) {
			//dialogue stuff
			drawDialogueScreen();
			}
		
		else {
		g2.drawString("Imposters caught : ", 50, 50);
		g2.drawString("Time : "+dFormat.format(playTime),gp.tileSize , 80);
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
	public void drawPauseScreen() {
		String text = "PAUSED";
		int x=getCenterForText(text);
		int y = gp.screenHeight/2 - 48;
		
		g2.drawString(text,x,y);
	}
	
	public void drawDialogueScreen() {
		
		//Dialogue window
		int x = gp.tileSize*2 ;
		int y = gp.tileSize/2 ;;
		int width = gp.screenWidth - (gp.tileSize*4);
		int height = gp.tileSize*4;
		
		drawSubWindow(x,y,width,height);
		g2.drawString(currentDialogue,x+48,y+48);

	}
	
	public void drawSubWindow(int x, int y, int width, int height) {
		
		Color c =new Color(0,0,0,210);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c =new Color(255,255,255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);

		
		
	}
	public int getCenterForText(String text) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x =gp.screenWidth/2 - length/2;
		return x;
		
	}
	
	
}
