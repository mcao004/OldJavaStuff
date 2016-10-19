/**
 * @(#)HealingItem.java
 *
 *
 * @author 
 * @version 1.00 2015/6/8
 */
 // completed


public class HealingItem extends FEItem{
	int hpRecovery;
	String extraEffects;
	int usesLeft, totalUses;
	final static String POISON = "Poison";
	static HealingItem Vulnerary = new HealingItem("Vulnerary", 1, 10, "None", 3);
	
    public HealingItem(String name, int index, int hp, String effects, int uses) {
    	super(name, index, true);
    	hpRecovery = hp;
    	extraEffects = effects;
    	usesLeft = uses;
    	totalUses = uses;;
    }
    
    /*public void checkUses() {
    	if (usesLeft == 0)
    		this = null;
    }*/
    
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