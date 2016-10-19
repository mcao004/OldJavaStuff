package FE.project.worlds;

import java.awt.Graphics;

import FE.project.Game;
import FE.project.tiles.*;
import FE.project.utils.*;
import FE.project.gfx.Assets;

public class World {
	
	private Game game;
	public int width, height;
	private int spawnX, spawnY;
	private int [][] tiles;
	private Tile [][] Tiles;
	
	public World(Game game){
		this.game = game;
		String path = "";
		loadWorld(path);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
//		int xStart = (int) Math.max(0, game.getGameCamera().getxOffset() / Tile.TILEWIDTH);
//		int xEnd = (int) Math.min(width, (game.getGameCamera().getxOffset() + game.getWidth()) / Tile.TILEWIDTH + 1);
//		int yStart = (int) Math.max(0, game.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
//		int yEnd = (int) Math.min(height, (game.getGameCamera().getyOffset() + game.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				getTile(x,y).render(g, x * Tile.TILEWIDTH , y * Tile.TILEHEIGHT);
				
				if (getTile(x,y).isBlue())
					g.drawImage(Assets.blueHighlight, x,y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
//				getTile(x,y).render(g, (int) (x * Tile.TILEWIDTH - game.getGameCamera().getxOffset()),
//				(int) (y * Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y){
		Tile t = Tiles[x][y];
		if (t == null)
			return Tile.dirtTile;
		return t;
	}
	
	public Tile[] getAdjacentTiles(int x, int y){
		Tile[] t = new Tile[4];
		if (x != tiles.length-1)
			t[0] = Tiles[x + 1][y];
		if (x != 0)
			t[1] = Tiles[x - 1][y];
		if (y != tiles[x].length-1)
			t[2]= Tiles[x][y + 1];
		if (y != 0)
			t[3] = Tiles[x][y - 1];
		
		return t;
	}
	
	public Tile[][] getAllTiles(){
		return Tiles;
	}
	
	private void loadWorld(String path){
	//	String file = Utils. loadFileAsString(path);
	//	String[] tokens = file.split("\\s+");
		width = 15; // Utils.parseInt(tokens[0]);
		height = 10; //Utils.parseInt(tokens[1]);
	//	spawnX = Utils.parseInt(tokens[2]);
	//	spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width] [height];
		Tiles = new Tile[width][height];
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				tiles[x][y] = 0; //Utils.parseInt(tokens[(x + y * width) + 4]);
				switch (tiles[x][y]){
					case 0:
						Tiles[x][y] = new GrassTile(0);
					default:
						Tiles[x][y] = new GrassTile(0);
				}
				Tiles[x][y].setX(x);
				Tiles[x][y].setY(y);
			} // x goes to 15 , y to 10
		}
		
		
	}
}
