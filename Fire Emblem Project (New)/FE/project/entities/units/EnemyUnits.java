package FE.project.entities.units;

import java.awt.*;
import java.awt.image.*;
import java.awt.Graphics;

import FE.project.entities.*;
import FE.project.*;
import FE.project.gfx.*;

public class EnemyUnits extends Unit{
	
	private boolean moved;
	
	public EnemyUnits(Game game, float x, float y, String n, String c, String affin, int lvl, int HP, int st, int sk, int sp, int lk,int df,
				int rs, int cn, int mv, char cWPLVL){
		super(game,x,y,n,c,affin,lvl,HP,st,sk,sp,lk,df,rs,cn,mv,0,0,0,0,0,0,0,cWPLVL);
		moved = false;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.drawImage(Assets.mapSpriteONeil, (int)x, (int)y, null); // only for Oneil for now
	}
}
