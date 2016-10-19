package FE.project.state;

import java.awt.Graphics;
import java.util.concurrent.*;

import FE.project.*;
import FE.project.tiles.*;
import FE.project.entities.*;
import FE.project.gfx.*;
import FE.project.entities.units.*; 
import FE.project.worlds.World;

public class GameState extends State {
	
	private MapCursor cursor;
	private World world;
	private PlayableUnit[] allyUnits= new PlayableUnit[10];
	private EnemyUnits[] enemyUnits = new EnemyUnits[10];
	
	public GameState(Game game){
		super(game);
		cursor = new MapCursor(game,32,32);
		PlayableUnit Eirika = new PlayableUnit(game, 32f, 32f, "Eirika", "Lord", "Light", 1, 16, 4,8,9,5,3,1,5,5,0.7,0.4,0.6,0.6,0.6,0.3,0.3,'E');
		EnemyUnits ONeil = new EnemyUnits(game, 192, 160, "ONeil", "Fighter", "Fire", 4, 23, 6,4,7,0,2,0,11,5,'D');
		allyUnits[0] = Eirika;
		enemyUnits[0] = ONeil;
		world = new World(game);
		
	}
	
	public void tick() {
		world.tick();
		for (Unit u : allyUnits){
			if (u != null)
				u.tick();
		}
		for (Unit u : enemyUnits){
			if (u != null)
				u.tick();
		}
		cursor.tick();
	}
	
	public void render(Graphics g){
		world.render(g);
		for (Unit u : allyUnits){
			if (u != null)
			u.render(g);
		}
		for (Unit u : enemyUnits){
			if (u != null)
			u.render(g);
		}
		cursor.render(g);
		
		if (cursor.getSelectedUnit() != null){
			highlightMovement(cursor.getSelectedUnit().getMovement());
		}
	}
	
	private void highlightMovement(int mov) {
		ConcurrentLinkedQueue<Tile> q = new ConcurrentLinkedQueue(); // queue for the amount tiles that will be checked
		Tile currTile = world.getTile((int)cursor.getX()/32, (int)cursor.getY()/32); // current tile the cursor is on
		currTile.setDistance(0);
		q.add(currTile); // add the current tile to the queue
		Tile thisTile;
		
		while (!q.isEmpty()){
			thisTile = q.poll();
			if (thisTile != null){
				thisTile.blueHighlight();
				Tile[] tileArray = world.getAdjacentTiles(thisTile.getX(), thisTile.getY());
				for (Tile t : tileArray){
					if (t != null){
						t.setDistance(thisTile.getDistance() + t.getCost());
						if (t.getDistance() > mov)
							t.TooFarAway();
						if (!t.isHighlighted() || !t.isSolid() || !t.isTooFarAway()) // if the current tile is already done, solid, or unreachable
							q.add(t);
					}
				}
			}
		}
	}
	
	public void resetTiles() {
		for (Tile[] ti : world.getAllTiles()){
			for (Tile t : ti)
				t.reset();
		}
	}
	
	public Unit[] getAllyUnits(){
		return allyUnits;
	}
	
	public Unit[] getEnemyUnits() {
		return enemyUnits;
	}
	
	public World getWorld() {
		return world;
	}
}
