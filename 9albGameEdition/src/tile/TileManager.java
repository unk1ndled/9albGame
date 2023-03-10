	package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePannel;
import main.Utilitytool;

public class TileManager {
	GamePannel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePannel gp) {
		
		this.gp = gp;
		
		tile = new Tile[50];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/map01.txt");
	}
	
	public void getTileImage() {

			setUp(0,"grass_tiles","grass01_top_left",false);
			setUp(1,"grass_tiles","grass01_top",false);
			setUp(2,"grass_tiles","grass01_top_right",false);
			setUp(3,"grass_tiles","grass01_left",false);
			setUp(4,"grass_tiles","grass01",false);
			setUp(5,"grass_tiles","grass01_right",false);
			setUp(6,"grass_tiles","grass01_bottom_left",false);
			setUp(7,"grass_tiles","grass01_bottom",false);
			setUp(8,"grass_tiles","grass01_bottom_right",false);
			setUp(9,"grass_tiles","tree01",true);
			
			setUp(10,"tiles","ground06",false);
			setUp(11,"tiles","inpt_default_outer_wall",true);
			setUp(12,"tiles","ground07",false);
			setUp(13,"tiles","floor01",false);
			setUp(14,"tiles","lightgrey",false);
			setUp(15,"tiles","floor01",false);
			setUp(16,"tiles","scenewall",true);
			setUp(17,"tiles","floor01",false);
			setUp(18,"zlafa","zlafa03",false);
			setUp(19,"zlafa","zlafa01",false);
			setUp(20,"zlafa","zlafa02",false);
			setUp(21,"zlafa","zlafa_inner_walll",true);
			setUp(22,"tiles","chbka",true);
			setUp(23,"tiles","greymarkings",false);
			setUp(24,"tiles","ground03",false);



	}
	
	public void setUp(int index,String imagePackage, String imageName,boolean collision) {
		Utilitytool uTool = new Utilitytool();
		
		try {
			tile[index]=new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/"+imagePackage+"/"+imageName+".png"));
			uTool.scaledImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision=collision;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String mapPath) {
		try {
			InputStream is = getClass().getResourceAsStream(mapPath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col =0;
			int row = 0;
			
			while(col<gp.maxWorldCol && row <gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col<gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row]=num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
			
		}catch(Exception e) {
			
		}
		
	}
	public void draw(Graphics2D g2) {
		//g2.drawImage(tile[0].image,0,0,gp.tileSize,gp.tileSize,null);
		
		int worldCol = 0 ;
		int worldRow = 0 ;

		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			//absolute position of a tile = screen center's absolute position + the distance between it and the tile (screenX=player.screenX)
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if( worldX + gp.tileSize > gp.player.worldX -gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
			}
			
			
			worldCol++;

			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
				
			}
			
		}
		
		
	}
	
	
	
}
