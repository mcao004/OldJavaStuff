package FE.project.state;

import java.awt.Graphics;

import FE.project.Game;
import FE.project.gfx.*;
import FE.project.state.*;

public class MenuState extends State {
	
	private static int renders = 0;
	private static final int RENDERDELAY = 20;
	
	public MenuState(Game game){
		super(game);
	}
	
	public void tick() {
		if (game.getKeyManager().enter)
			game.setState(game.getGameState());
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.fullMenu, 0, 0, null);
		if (renders > RENDERDELAY) 
			g.drawImage(Assets.menuCursor, 130, 231, null);
		if (renders == 40) // for the blinking effect on the menu cursor
			renders = 0;
		renders ++;
	}
}
