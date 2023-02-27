	package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePannel;

public class TileManager {
	GamePannel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePannel gp) {
		
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/map01.txt");
	}
	
	public void getTileImage() {
		try {
			
			//hna relation bin tiles w png 
			tile[1] =new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));
			
			
			tile[0] =new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/red01.png"));
			//tile[1].collision=true;
		}
		catch(IOException e) {
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
