package FE.project.entities.items;

import java.awt.Graphics;


import FE.project.entities.*;
import FE.project.*;
import FE.project.entities.items.*;

public class HealingItem extends FEItem{
	int hpRecovery;
	String extraEffects;
	int usesLeft, totalUses;
	final static String POISON = "Poison";
//	static HealingItem Vulnerary = new HealingItem("Vulnerary", 1, 10, "None", 3);
	
    public HealingItem(Game game, float x, float y, int width, int height, String name, int index, int hp, String effects, int uses) {
    	super(game, x, y, width, height, name, index, true);
    	hpRecovery = hp;
    	extraEffects = effects;
    	usesLeft = uses;
    	totalUses = uses;;
    }
    
    /*public void checkUses() {
    	if (usesLeft == 0)
    		this = null;
    }*/
    
    public void tick() {
    	
    }
    
    public void render(Graphics g) {
    	
    }
    
    public void setUses(int i) {
    	usesLeft = i;
    }
    
    public int getUses() {
    	return usesLeft;
    }
    
    public int getHpRecov() {
    	return hpRecovery;
    }
    
    public String getEffect() {
    	return extraEffects;
    }
    
    
}