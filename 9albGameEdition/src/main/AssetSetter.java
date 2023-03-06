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

	}
}
