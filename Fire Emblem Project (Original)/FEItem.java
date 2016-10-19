/**
 * @(#)Item.java
 *
 *
 * @author 
 * @version 1.00 2015/6/8
 */
 // completed


public abstract class FEItem {
	private String itemName;
	private int itemIndex;
	private boolean usable;
	
    public FEItem(String itName, int index, boolean canUse) {
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