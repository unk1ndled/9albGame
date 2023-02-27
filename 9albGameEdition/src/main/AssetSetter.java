package main;

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
}
