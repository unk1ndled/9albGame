package entity;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePannel;

public class NPC extends Entity{

	public NPC(GamePannel gp,String npcName ) {
		super(gp);
		direction = "down";
		speed = 3;
		getNPCImage(npcName);
	}
	


	public void getNPCImage(String npcName)
	{
		try{
			
			up1= ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_up_right.png"));
			up2= ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_up_left.png"));
			down1= ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_down_left.png"));
		    down2= ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_down_right.png"));
			left1= ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_left_1.png"));
			left2= ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_left_2.png"));
			right1= ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_right_1.png"));
			right2= ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_right_2.png"));
			restDown=ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_down_rest.png"));
			restUp=ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_up_rest.png"));
			restLeft=ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_rest_left.png"));
			restRight=ImageIO.read(getClass().getResourceAsStream("/"+npcName+"/"+npcName+"_rest_right.png"));

		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setAction() {
		
		
		this.actionLockCounter++;
		
		Random random = new Random();
		int i = random.nextInt(100)+1;
		
		if (this.actionLockCounter==110) {
			
			int j = random.nextInt(3);
			
			if (j==2) { 
				this.isResting=true;
				actionLockCounter=0;
			}
			
			else {
			this.isResting=false;

			if (i<=25) {
				direction = "up";
			}
			
			if ((i>25)&&(i<50)) {
				direction = "down";
			}
			
			if ((i>50)&&(i<75)) {
				direction = "left";
			}
			
			if (i>75) {
				direction = "right";
			}
			
			actionLockCounter=0;
			} 
			}

	}

}
