package main;

import java.util.List;
import java.util.Random;

import entity.NPC;
import object.OBJ_Coffee;
import object.OBJ_Table;
import object.OBJ_Tutorial;
import object.OBJ_Wanted;
import tile.PositionRemade;
import object.OBJ_Chair;

public class AssetSetter {
	
	GamePannel gp;
	
	public Random rand = new Random();
	
	int GR,RH,BR,CD,PU;
	int numberOfNpcs;
	
	public AssetSetter(GamePannel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[99] = new OBJ_Tutorial();
		gp.obj[99].worldX = 52*gp.tileSize - 428/2;
		gp.obj[99].worldY = 94*gp.tileSize - 621/2;
		
		gp.obj[98] = new OBJ_Wanted();
		gp.obj[98].worldX = 49*gp.tileSize;
		gp.obj[98].worldY = 89*gp.tileSize;
			
		
		gp.obj[0] = new OBJ_Coffee();
		gp.obj[0].worldX=10 * gp.tileSize;
		gp.obj[0].worldY=10*gp.tileSize;
		//gp.obj[0].worldX=5 ;
		//gp.obj[0].worldY=5;
		
		//---------TABLES
		gp.obj[1] = new OBJ_Table();
		gp.obj[1].worldX=7* gp.tileSize;
		gp.obj[1].worldY=83* gp.tileSize;
		
		gp.obj[2] = new OBJ_Table();
		gp.obj[2].worldX=7* gp.tileSize;
		gp.obj[2].worldY=88* gp.tileSize;
		
		gp.obj[3] = new OBJ_Table();
		gp.obj[3].worldX=7* gp.tileSize;
		gp.obj[3].worldY=93* gp.tileSize;
		
		gp.obj[4] = new OBJ_Table();
		gp.obj[4].worldX=7* gp.tileSize;
		gp.obj[4].worldY=98* gp.tileSize;
		
		gp.obj[5] = new OBJ_Table();
		gp.obj[5].worldX=23* gp.tileSize;
		gp.obj[5].worldY=83* gp.tileSize;
		
		gp.obj[6] = new OBJ_Table();
		gp.obj[6].worldX=23* gp.tileSize;
		gp.obj[6].worldY=88* gp.tileSize;
		
		gp.obj[7] = new OBJ_Table();
		gp.obj[7].worldX=23* gp.tileSize;
		gp.obj[7].worldY=93* gp.tileSize;
		
		gp.obj[8] = new OBJ_Table();
		gp.obj[8].worldX=23* gp.tileSize;
		gp.obj[8].worldY=98* gp.tileSize;
		
		//--------CHAIRS FACING DOWN
		
		//----Y 97
		gp.obj[9] = new OBJ_Chair("DOWN");
		gp.obj[9].worldX=32* gp.tileSize;
		gp.obj[9].worldY=97* gp.tileSize;
		
		gp.obj[10] = new OBJ_Chair("DOWN");
		gp.obj[10].worldX=30* gp.tileSize;
		gp.obj[10].worldY=97* gp.tileSize;
		
		
		gp.obj[12] = new OBJ_Chair("DOWN");
		gp.obj[12].worldX=26* gp.tileSize;
		gp.obj[12].worldY=97* gp.tileSize;
		
		gp.obj[13] = new OBJ_Chair("DOWN");
		gp.obj[13].worldX=24* gp.tileSize;
		gp.obj[13].worldY=97* gp.tileSize;
		
		//----Y 92
		gp.obj[14] = new OBJ_Chair("DOWN");
		gp.obj[14].worldX=32* gp.tileSize;
		gp.obj[14].worldY=92* gp.tileSize;
		
		gp.obj[15] = new OBJ_Chair("DOWN");
		gp.obj[15].worldX=30* gp.tileSize;
		gp.obj[15].worldY=92* gp.tileSize;
		
		
		gp.obj[16] = new OBJ_Chair("DOWN");
		gp.obj[16].worldX=26* gp.tileSize;
		gp.obj[16].worldY=92* gp.tileSize;
		
		gp.obj[17] = new OBJ_Chair("DOWN");
		gp.obj[17].worldX=24* gp.tileSize;
		gp.obj[17].worldY=92* gp.tileSize;
		
		//----Y 87
		gp.obj[18] = new OBJ_Chair("DOWN");
		gp.obj[18].worldX=32* gp.tileSize;
		gp.obj[18].worldY=87* gp.tileSize;
		
		gp.obj[19] = new OBJ_Chair("DOWN");
		gp.obj[19].worldX=30* gp.tileSize;
		gp.obj[19].worldY=87* gp.tileSize;
		
		
		gp.obj[20] = new OBJ_Chair("DOWN");
		gp.obj[20].worldX=26* gp.tileSize;
		gp.obj[20].worldY=87* gp.tileSize;
		
		gp.obj[21] = new OBJ_Chair("DOWN");
		gp.obj[21].worldX=24* gp.tileSize;
		gp.obj[21].worldY=87* gp.tileSize;
		
		//----Y 82
		gp.obj[22] = new OBJ_Chair("DOWN");
		gp.obj[22].worldX=32* gp.tileSize;
		gp.obj[22].worldY=82* gp.tileSize;
		
		gp.obj[23] = new OBJ_Chair("DOWN");
		gp.obj[23].worldX=30* gp.tileSize;
		gp.obj[23].worldY=82* gp.tileSize;
		
		
		gp.obj[24] = new OBJ_Chair("DOWN");
		gp.obj[24].worldX=26* gp.tileSize;
		gp.obj[24].worldY=82* gp.tileSize;
		
		gp.obj[25] = new OBJ_Chair("DOWN");
		gp.obj[25].worldX=24* gp.tileSize;
		gp.obj[25].worldY=82* gp.tileSize;
		
		//----CHAIRS FACING UP
		gp.obj[26] = new OBJ_Chair("UP");
		gp.obj[26].worldX=31* gp.tileSize;
		gp.obj[26].worldY=100* gp.tileSize;
		
	}
	
	public void setNPC2() {
		
		this.BR=20;
		this.CD=20;
		this.GR=20;
		this.PU=20;
		this.RH=10;
		
		
		
		InstantiateNPC("blackrizz",BR);
		InstantiateNPC("comandos",CD);
		InstantiateNPC("greenRizz",GR);
		InstantiateNPC("punisher",PU);
		InstantiateNPC("redHacker",RH);
		
	}
	
	public void InstantiateNPC(String npcName, int npcAmount) {
		
		List<PositionRemade> avalablePositions=gp.tileM.availablePositions;
		
		for (int i = 0; i < npcAmount; i++) {
			
			if (i==gp.npc.length) {
				break;
			}
			
			NPC npc =new NPC(gp, npcName);
			
			
			int j = rand.nextInt(avalablePositions.size());
			
			PositionRemade p= avalablePositions.get(j);
			
			npc.worldX=(p.getX())*gp.tileSize;
			npc.worldY=(p.getY())*gp.tileSize;
			
			gp.npc[numberOfNpcs++]=npc;
		}
		
	}
	
	
	

}
