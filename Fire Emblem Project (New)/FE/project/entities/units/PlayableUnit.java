package FE.project.entities.units;
// incomplete

import java.awt.*;
import java.awt.image.*;
import java.awt.Graphics;

import FE.project.tiles.*;
import FE.project.entities.*;
import FE.project.*;
import FE.project.gfx.*;


public class PlayableUnit extends Unit{
	
	private boolean moved;
	private boolean selected;
	
	public PlayableUnit(Game game, float x, float y, String n, String c, String affin, int lvl, int HP, int st, int sk, int sp, int lk,int df,
				int rs, int cn, int mv, double hpg, double stg, double skg, double spg, double lkg,double  dfg, double rsg, char cWPLVL){
		super(game,x,y,n,c,affin,lvl,HP,st,sk,sp,lk,df,rs,cn,mv,hpg,stg,skg,spg,lkg,dfg,rsg,cWPLVL);
		moved = false;
		selected = false;
		
	}
	
	public void tick() {
		if (selected){
			int oldx = (int)getX();
			int oldy = (int)getY();
			
			if (game.getKeyManager().up)
				this.y -= Tile.TILEHEIGHT;
			if (game.getKeyManager().down)
				this.y += Tile.TILEHEIGHT;
			if (game.getKeyManager().left)
				this.x -= Tile.TILEHEIGHT;
			if (game.getKeyManager().right)
				this.x += Tile.TILEHEIGHT;
			
			if (game.getKeyManager().exit){
				selected = false;
				this.x = oldx;
				this.y = oldy;
			}
			if (game.getKeyManager().enter){
				// display the options at new position
				
			}
				
			
		}
		
	}
	
	public void render(Graphics g) {
		
		// map animation
		g.drawImage(Assets.mapSpriteEirika, (int)x , (int)y, null); // only for Eirika right now
	}
	
	public void select() {
		selected = true;
	}
	
	public void deselect() {
		selected = false;
	}
}
