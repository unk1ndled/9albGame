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
	
	public boolean gameFinished = false;
	
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
			drawSubWindow(5,5,gp.tileSize*6,gp.tileSize*2 + 15);
			playTime +=(double)1/60;
			
			if(playTime >= 300) {
				gp.gameState = gp.gameFinished;
			}
			
			g2.drawString("Imposters caught : "+gp.player.impostersCaught, gp.tileSize, gp.tileSize);
			g2.drawString("Remaining Time : "+dFormat.format(300-playTime),gp.tileSize , 80);
			
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
		
		
		
		if (gp.gameState==gp.pauseState) {
			//pauseState stuff
			drawPauseScreen(playTime);
			}
		
		
		if (gp.gameState==gp.dialogueState) {
			//dialogue stuff
			drawDialogueScreen();
			}
		
		if(gp.gameState == gp.gameFinished) {
			drawFinishedScreen();
		}
		
		else {
		
		}
		

	}
	public void drawPauseScreen(double playTime) {
		
		drawSubWindow(gp.tileSize*2,gp.tileSize*3,gp.tileSize*12,gp.tileSize*5);
		String text = "PAUSED";
		int x=getCenterForText(text);
		int y = gp.screenHeight/2 - 48;
		
		g2.drawString(text,x,y);
		g2.drawString("Imposters caught : "+gp.player.impostersCaught, getCenterForText("Imposters left : 10")-gp.tileSize*3, gp.tileSize*6 + 20);
		g2.drawString("Time : "+dFormat.format(playTime),getCenterForText("Imposters caught : ")+gp.tileSize*3 + 20, gp.tileSize*6 + 20);
	}
	
	public void drawDialogueScreen() {
		
		//Dialogue window
		int x = gp.tileSize*2 ;
		int y = gp.tileSize/2 ;;
		int width = gp.screenWidth - (gp.tileSize*4);
		int height = gp.tileSize*4;
		
		drawSubWindow(x,y,width,height);
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20f));
		x+=gp.tileSize;
		y+=gp.tileSize;
		for(String line : currentDialogue.split("/n")) {
			g2.drawString(line,x,y);
			y+=40;
		}

	}
	public void drawFinishedScreen() {
		drawSubWindow(gp.tileSize*2,gp.tileSize*3,gp.tileSize*12,gp.tileSize*5);
		String text = "GAME FINISHED";
		int x=getCenterForText(text);
		int y = gp.screenHeight/2 - 48;
		
		g2.drawString(text,x,y);
		g2.drawString("Imposters caught : "+gp.player.impostersCaught, getCenterForText("Imposters left : 10")-gp.tileSize*3, gp.tileSize*6 + 20);
		g2.drawString("Time : "+dFormat.format(playTime),getCenterForText("Imposters caught : ")+gp.tileSize*3 + 20, gp.tileSize*6 + 20);
		
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
