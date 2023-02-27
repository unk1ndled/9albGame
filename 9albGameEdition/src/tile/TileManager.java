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
		
		tile = new Tile[25];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/map01.txt");
	}
	
	public void getTileImage() {
		try {
			
			//hna relation bin tiles w png 
			tile[0] =new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/grass_tiles/grass01_top_left.png"));
			//tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png"));
			
			tile[1] =new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/grass_tiles/grass01_top.png"));

			tile[2] =new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/grass_tiles/grass01_top_right.png"));
			
			tile[3] =new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/grass_tiles/grass01_left.png"));
			
			tile[4] =new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/grass_tiles/grass01.png"));
			
			tile[5] =new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/grass_tiles/grass01_right.png"));
			
			tile[6] =new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/grass_tiles/grass01_bottom_left.png"));
			
			tile[7] =new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/grass_tiles/grass01_bottom.png"));
			
			tile[8] =new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/grass_tiles/grass01_bottom_right.png"));
			
			tile[9] =new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/grass_tiles/tree01.png"));
			
			tile[10] =new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ground03.png"));
			
			tile[11] =new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/inpt_default_outer_wall.png"));
			
			tile[12] =new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ground01.png"));
			
			tile[13] =new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png"));

			tile[14] =new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lightgrey.png"));
			
			tile[15] =new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png"));
			
			tile[16] =new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png"));
			
			tile[17] =new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png"));
			
			tile[18] =new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png"));
			
			tile[19] =new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png"));
			
			tile[20] =new Tile();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png"));
			
			tile[21] =new Tile();
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png"));
			
			tile[22] =new Tile();
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/chbkapngdddddddddddd.png"));
			
			tile[23] =new Tile();
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/greymarkings.png"));
			
			tile[24] =new Tile();
			tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png"));

			
<<<<<<< Updated upstream
			
			tile[0] =new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/red01.png"));
			//tile[1].collision=true;
=======
>>>>>>> Stashed changes
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
