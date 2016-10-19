package FE.project.entities.items;

import FE.project.*;
import FE.project.entities.*;

public abstract class FEItem extends Entity{
	private String itemName;
	private int itemIndex;
	private boolean usable;
	
    public FEItem(Game game, float x, float y, int width, int height, String itName, int index, boolean canUse) {
    	super(game, x, y, width, height);
    	itemName = itName;
    	itemIndex = index;
    	usable = canUse;
    }
    
    public void setName(String name){
    	itemName = name;
    }
    
    public void setIndex(int index){
    	itemIndex = index;
    }
    
    public void setUsability(boolean canUse) {
    	usable = canUse;
    }
    
    public String getName() {
    	return itemName;
    }
    
    public int getIndex() {
    	return itemIndex;
    }
    
    public boolean getUsability() {
    	return usable;
    }
    
    
    
}