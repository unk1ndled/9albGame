package main;

import entity.NPC;
import object.OBJ_Coffee;

public class AssetSetter {
	
	GamePannel gp;
	
	public AssetSetter(GamePannel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[0] = new OBJ_Coffee();
		gp.obj[0].worldX=10 * gp.tileSize;
		gp.obj[0].worldY=10*gp.tileSize;
		//gp.obj[0].worldX=5 ;
		//gp.obj[0].worldY=5;
				
	}
	public void setNPC() {
		gp.npc[0]= new NPC(gp,"greenRizz");
		gp.npc[0].worldX=gp.tileSize*52;
		gp.npc[0].worldY=gp.tileSize*99;

		
		gp.npc[1]= new NPC(gp,"redHacker");
		gp.npc[1].worldX=gp.tileSize*45;
		gp.npc[1].worldY=gp.tileSize*99;
		
		
		gp.npc[2]= new NPC(gp,"blackrizz");
		gp.npc[2].worldX=gp.tileSize*45;
		gp.npc[2].worldY=gp.tileSize*89;
		
		gp.npc[3]= new NPC(gp,"punisher");
		gp.npc[3].worldX=gp.tileSize*60;
		gp.npc[3].worldY=gp.tileSize*89;
		
		gp.npc[4]= new NPC(gp,"comandos");
		gp.npc[4].worldX=gp.tileSize*60;
		gp.npc[4].worldY=gp.tileSize*89;

	}
}
