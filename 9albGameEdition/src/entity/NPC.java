package entity;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePannel;

public class NPC extends Entity{
	
	String npcName;
	

	public NPC(GamePannel gp,String npcName ) {
		super(gp);
		direction = "down";
		speed = 3;
		this.npcName=npcName;
		getNPCImage(npcName);
		
		solidArea.x= 10;
		solidArea.y= 26;
		
		solidAreaDefaultX=solidArea.x;
		solidAreaDefaultY=solidArea.y;
		
		solidArea.width= 24;
		solidArea.height= 20; 
		
		if (npcName=="redHacker")
		{
			this.speed=5;
		}
		
		setDialogue();	}
	


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
		
		if (this.actionLockCounter==this.actiontimer) {
			actiontimer=random.nextInt(50)+80;

			
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
	
	public void setDialogue() {
		
		if ((npcName=="greenRizz")||(npcName=="blackrizz")) {
		dialogues[0]="Hiii. ";
		dialogues[1]="Today's event has been really fun, you've outdone /nyourselves this time";
		dialogues[2]="I think im gonna go grab some ice-cream with my /nfriends, see you later <3";
		dialogues[3]="Bye <3 <3";
		}
		
		if (npcName=="blackrizz") {
			dialogues[0]="Hello, cutie  ♪♪ ";
			dialogues[1]="I heard mr Lone was perfoming tonight, I'm so looking /nforward to it, If you're free we can go together   ♪♪ ";
			dialogues[2]="Oh you're busy then I guess we can meet later /nanyway if you change your mind meet me by the /nice-cream kiosk I'll be with y friends  ♪♪";
			dialogues[3]=" ♪♪ NEVER EVER, have I changed on my ni......♪♪";
			dialogues[4]=" ♪♪ damn,how the ... we got to where we started ? ♪♪ /n♪♪ this love don't feel the same like when /nwe  we started ♪♪";
			dialogues[5]=" ♪♪ ..... ♪♪ ";

		}
		
		if (npcName=="punisher") {
			dialogues[0]="Sup!";
			dialogues[1]="Am I having fun? Well I guess its decent over here. /nDon't get me wrong its nothing special, our school will /ndefinetely organise the better event!";
			dialogues[2]="Well, see ya later I'm tryna get me an I.A.V girl, /nI heard they were pretty.";
			dialogues[3]="Quick, I think I saw a red hacker over there";
			dialogues[4]="Shoo, you're scaring the hoes";
			}
		
		if (npcName=="comandos") {
			dialogues[0]="Oh!!! Sir,Yes Sir! ";
			dialogues[1]="Tsk, so its just you ";
			dialogues[2]="Me??, Scared of my commandant??,you're joking right, /nwell tbh I should be on duty rn so please can you keep /nme being here a scret will you?";
			dialogues[3]="Don't you have intruders to take care of ?? if i were /nyou I'd better get going those red hackers are no good.";
			}
		
		if (npcName=="redHacker") {
			dialogues[0]="Oh shoot.. ";
			dialogues[1]="I'm sorry okay I'll never come back again, /njust let me gooo!!!";
			dialogues[2]="Okay Okay, you got me just don't hit the face!!";
			dialogues[3]="ugh!!";
			}

		
	}
	
	public void speak() {
		
		switch(gp.player.direction) {
		
		case "up":
			this.direction="down";
			break;

		case "down":
			this.direction="up";
			break;
			
		case "left":
			this.direction="right";
			break;
			
		case "right":
			this.direction="left";
			break;
		}
		
		if(dialogues[dialogueIndex]==null) {
			if(this.npcName=="redHacker") {
				int i =gp.getNpcIndex(this);
				gp.npc[i]=null;
				gp.player.impostersCaught++;
			}
			dialogueIndex-=1;;}
		
		gp.ui.currentDialogue=dialogues[dialogueIndex];
		dialogueIndex++;
	}

}
