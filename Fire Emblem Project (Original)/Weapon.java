/**
 * @(#)Weapon.java
 *
 *
 * @author 
 * @version 1.00 2015/6/8
 */
 // completed


public class Weapon extends FEItem{
	
	static Weapon Rapier = new Weapon("Rapier", 0, false, "Sword", 40, 7, 95, 10, 5, 'E');
	static Weapon IronAxe = new Weapon("Iron Axe", 2, false, "Axe", 45, 8, 75, 0, 10, 'E');

	String wepClass;
	int durability, might, hit, crit, weight;
	char weaponLevel;
    
    public Weapon(String name, int index, boolean canUse, String wpClass, int dur, int mt, int ht, int crt, int wgt, char wplvl) {
    	super(name, index,canUse);
    	wepClass = wpClass;
    	durability = dur;
    	might = mt;
    	hit = ht;
    	crit = crt;
    	weight = wgt;
    	weaponLevel = wplvl;
    }
    
    public void use() {
    	durability--;
    }
    
    public String getWepClass() {
    	return wepClass;
    }
    
    public int getDur() {
    	return durability;
    }
    
    public int getMight() {
    	return might;
    }
    
    public int getHit() {
    	return hit;
    }
    
    public int getCrit() {
    	return crit;
    }
    
    public int getWeight() {
    	return weight;
    }
    
    public char getWeaponLevel() {
    	return weaponLevel;
    }
    
}