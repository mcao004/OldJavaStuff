package FE.project.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import FE.project.gfx.*;

public class Tile {
	
	// Static tiles
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile mountainTile = new MountainTile(2);
	public static Tile forestTile = new ForestTile(3);
	public static Tile villageTile = new VillageTile(4);
	public static Tile fortTile = new FortTile(5);
	public static Tile bridgeUpTile = new BridgeUpTile(6);
	public static Tile bridgeSideTile = new BridgeSideTile(7);
	public static Tile riverTile = new RiverTile(8);
	public static Tile redHighlight = new RedHighlight(9);
	public static Tile blueHighlight = new BlueHighlight(10);
	
	// class
	
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	protected BufferedImage texture;
	protected final int id;
	protected int defense, avoid, cost;
	protected boolean redhighlight, bluehighlight, tooFarAway;
	protected int distance;
	protected int x, y;
	
	public boolean visited = false;
	public int dist = -1;
	
	public Tile(BufferedImage texture, int id, int defense, int avoid, int cost) {
		this.texture = texture;
		this.id = id;
		this.defense = defense;
		this.avoid = avoid;
		this.cost = cost;
		bluehighlight = false;
		redhighlight = false;
		tooFarAway = false;
		distance = 0;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
		if (bluehighlight)
			g.drawImage(Assets.blueHighlight, x, y, TILEWIDTH, TILEHEIGHT, null);
		if (redhighlight)
			g.drawImage(Assets.redHighlight, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isTooFarAway(){
		return tooFarAway;
	}
	
	public void TooFarAway(){
		tooFarAway = true;
	}
	
	public void reset() {
		bluehighlight = false;
		redhighlight = false;
		tooFarAway = false;
		distance = 0;
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public boolean isHighlighted() {
		return (redhighlight || bluehighlight);
	}
	
	public void redHighlight() {
		redhighlight = true;
	}
	
	public boolean isRed() {
		return redhighlight;
	}
	
	public void blueHighlight() {
		bluehighlight = true;
	}
	
	public boolean isBlue() {
		return bluehighlight;
	}
	
	public void setDistance(int i) {
		distance = i;
	}
	
	public int getDistance(){
		return distance;
	}
	
	public int getId(){
		return id;
	}
	
	public int getDefense(){
		return defense;
	}
	
	public int getAvoid(){
		return avoid;
	}
	
	public int getCost(){
		return cost;
	}
	
	public void setX(int i) {
		x = i;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int i) {
		y = i;
	}
	
	public int getY() {
		return y;
	}
}
