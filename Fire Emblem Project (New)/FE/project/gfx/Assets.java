package FE.project.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage mapSpriteEirika, mapSpriteONeil, dirt, grass, mountain, forest, village, fort, bridgeUp, bridgeSide, river, redHighlight, blueHighlight;
	public static BufferedImage prologueMap,menuBackground, menuForeground;
	public static BufferedImage menuCursor;
	public static BufferedImage battleEirika, battleONeil;
	public static BufferedImage cursor;
	public static BufferedImage grassFight;
	public static BufferedImage fullMenu;
	
	public static void init(){
		SpriteSheet mapSpriteSheet = new SpriteSheet(ImageLoader.loadImage("Game Boy Advance - Fire Emblem 8 The Sacred Stones - Map Sprites.png"));
		SpriteSheet battleBGSheet = new SpriteSheet(ImageLoader.loadImage("BattleBackgroundsSheet.png"));
		SpriteSheet pm = new SpriteSheet(ImageLoader.loadImage("PrologueMap.png"));
		SpriteSheet menu = new SpriteSheet(ImageLoader.loadImage("Menus.png"));
		SpriteSheet ch1Sheet = new SpriteSheet(ImageLoader.loadImage("Ch1Map.png"));
		SpriteSheet cursorSheet = new SpriteSheet(ImageLoader.loadImage("MapCursor.png"));
		SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("Tiles.png"));
		
		fullMenu = ImageLoader.loadImage("FE8 SS Menu.png");
		menuBackground = menu.crop(247,4,240,160);
		menuForeground = ImageLoader.loadImage("FE8 SS Menu(blank).png");
		
		mapSpriteEirika = ImageLoader.loadImage("EirikaOnMap.gif");
		mapSpriteONeil = ImageLoader.loadImage("FighterOnMap.gif");
		prologueMap = pm.crop(0,0,240,160);
		
		battleEirika = ImageLoader.loadImage("eirika_lord_sword.gif");
		battleONeil = ImageLoader.loadImage("o`neil_fighter_axe.gif");
		
		grassFight = battleBGSheet.crop(2,2,240,160);
		
		cursor = cursorSheet.crop(26,0,32,32);
		menuCursor = cursorSheet.crop(0,32,224,64);
		
		grass = tiles.crop(0,0,width, height);
		dirt = tiles.crop (width * 1, 0, width, height);
		mountain = tiles.crop (width * 2, 0, width, height);
		forest = tiles.crop (width * 3, 0, width, height);
		village = tiles.crop(width * 4, 0, width, height);
		fort = tiles.crop(width * 5, 0, width, height);
		bridgeUp = tiles.crop (width * 6, 0, width, height);
		bridgeSide = tiles.crop (width * 7, 0, width, height);
		river = tiles.crop (width * 8, 0, width, height);
		redHighlight = tiles.crop (width * 9, 0, width, height);
		blueHighlight = tiles.crop (0, height, width, height);
	}
}
/* 

*/