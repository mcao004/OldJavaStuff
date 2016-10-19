package FE.project.entities;

import java.awt.Graphics;
import java.util.concurrent.*;

import FE.project.tiles.*;
import FE.project.Game;
import FE.project.state.*;
import FE.project.gfx.Assets;
import FE.project.entities.*;
import FE.project.entities.units.*;

public class MapCursor extends Entity {
	
	public static final int DEFAULT_CURSOR_WIDTH = 32;
	public static final int DEFAULT_CURSOR_HEIGHT = 32;
	public static final float DEFAULT_SPEED = 32f;
	public static final int BLINKINGRENDER = 30;
	
	private int renders;
	protected float xMove, yMove;
	protected float speed;
	protected Unit selectedUnit;
	
	public MapCursor(Game game, float x, float y){
		super(game, x, y, DEFAULT_CURSOR_WIDTH, DEFAULT_CURSOR_HEIGHT);
		renders = 0;
		xMove = 0;
		yMove = 0;
		speed = DEFAULT_SPEED;
	}
	
	public void tick() {
		getInput();
		move();
	//	game.getGameCamera().centerOnEntity(this);
	}
	
	public void move(){
		x += xMove;
		y += yMove;
	}
	
	public void getInput(){
		xMove = 0;
		yMove = 0;
		
		if (game.getKeyManager().up)
			yMove = -speed;
		if (game.getKeyManager().down)
			yMove = speed;
		if (game.getKeyManager().left)
			xMove = -speed;
		if (game.getKeyManager().right)
			xMove = speed;
			
		if (game.getKeyManager().enter){
			if (selectedUnit == null)
				if (((GameState)game.getGameState()).getAllyUnits()[0].getX() == this.x && ((GameState)game.getGameState()).getAllyUnits()[0].getY() == this.y){
					selectedUnit = (PlayableUnit)(((GameState)game.getGameState()).getAllyUnits()[0]);
			//		selectedUnit.select();
			//	} // else
					// display map options
			}
		//	else 
		//		if () check if it is a tile the unit can move onto in that turn
				
		}		
		if (game.getKeyManager().exit) {
			if (selectedUnit != null){ 
		//		selectedUnit.deselect();
				selectedUnit = null;
				((GameState)game.getGameState()).resetTiles();
			}else{
				changeToMenuState();
		}
		}
			
	}
	
	public void render(Graphics g){
//		g.drawImage(Assets.cursor, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
		renders++;
		if (renders < BLINKINGRENDER)
			g.drawImage(Assets.cursor, (int)x, (int)y, width, height, null);
		if (renders == BLINKINGRENDER * 2);
			renders = 0;
		if (selectedUnit != null){
			highlightMovement(selectedUnit.getMovement());
		}
	}
	
	private void highlightMovement(int mov) {
		ConcurrentLinkedQueue<Tile> q = new ConcurrentLinkedQueue();
	}
	
	public Unit getSelectedUnit() {
		return selectedUnit;
	}
	
	public void changeToMenuState(){
		game.setState(game.getMenuState());
	}
	
	public float getxMove(){
		return xMove;
	}
	
	public float getyMove(){
		return yMove;
	}
	
	public void setxMove(float xMove){
		this.xMove = xMove;
	}
	
	public void setyMove(float yMove){
		this.yMove = yMove;
	}
}
