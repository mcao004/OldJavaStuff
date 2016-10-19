/**
 * @(#)Character.java
 *
 *
 * @author 
 * @version 1.00 2015/6/8
 */
 // incomplete: need to implement movement, attacking, etc.
 
import javax.swing.*;
import java.awt.*;

public class Unit extends Component{
	
	static Unit Eirika = new Unit("Eirika", "Lord", "Light", 1, 16, 4,8,9,5,3,1,5,5,.7,.4,.6,.6,.6,.3,.3,'E', 10,10, "FE8_Eirika_Lord_Map_Sprite.gif");
	static Unit ONeil = new Unit("ONeil", "Fighter", "Fire", 4, 23, 6,4,7,0,2,0,11,5, 0,0,0,0,0,0,0,'D',18,18, "FE8_Fighter_Map_Sprite.gif");

	private int xLocation, yLocation; // between 0 - 10 for each
	private String name, className; // classNames include Lord and Fighter at the moment
	private ImageIcon image;////////////////////////////////////////////////////////////////////////////////////do it
	private FEItem[] inventory = new FEItem[5];
	private Weapon equipment;
	private String affinity;
	private String weaponTypes;
	private int level, currHP, fullHP, str , skl, spd, lck, def, res, con, mov; // strength/magic, skill, speed, luck, resistance, constitution, movement
	private double hpGrowth, strGrowth, sklGrowth, spdGrowth, lckGrowth,defGrowth, resGrowth; // growth rates
	private int exp;
	private char capableWeaponLevel;
	private String status;
	

    public Unit(String n, String c, String affin, int lvl, int HP, int st, int sk, int sp, int lk,int df, int rs, int cn, int mv, double hpg, double stg, double skg, double spg, double lkg,double  dfg, double rsg, char cWPLVL, int x, int y, String gif) {
    	name = n;
    	
    	if (c == "Lord")
    		weaponTypes = "Swords";
    	else
    		weaponTypes = "Axes";
    	className = c;
    	affinity = affin;
    	level = lvl;
    	currHP = HP;
    	fullHP = HP;
    	str = st;
    	skl = sk;
    	spd = sp;
    	lck = lk;
    	def = df;
    	res = rs;
    	con = cn;
    	mov = mv;
    	hpGrowth = hpg;
    	strGrowth = stg;
    	sklGrowth = skg;
    	spdGrowth = spg;
    	lckGrowth = lkg;
    	defGrowth = dfg;
    	resGrowth = rsg;
    	capableWeaponLevel = cWPLVL;
    	exp = 0;
    	xLocation = x;
    	yLocation = y;
    	image = new ImageIcon (gif);
    	
    	
    }
    
    public String getName(){
    	return name;
    }
    
    public String getUnitClass() {
    	return className;
    }
    
    public Weapon getEquipment() {
    	return equipment;
    }
    
    public ImageIcon showUnitDisplay(){
    	return image;
    }
    
    public int getMovement(){
    	return mov;
    }
    
    public FEItem[] getInventory() {
    	return inventory;
    }
    
    /*public void move(int newX, int newY){
    	
    }*/
    
    public void giveExp (int i) {
    	exp += i;
    }
    
    public void getItem(FEItem i) {
    	if (inventory[0] == null)
    		inventory [0] = i;
    	else if (inventory [1] == null)
    		inventory [1] = i;
    	else if (inventory [2] == null)
    		inventory [2] = i;
    	else if (inventory [3] == null)
    		inventory [3] = i;
    	else
    		inventory [4] = i;
    }
    
    public FEItem viewItem(int index) {
    	return inventory[index];
    }
    
    /*public void giveItem(Unit u, int inven) {
    	
    }*/
    
    public void takeItem(Unit u, int inven) {
    	getItem(u.getInventory()[inven]);
    	u.dropItem(inven);
    }
    
    public void dropItem(int inven) {
    	inventory[inven] = null;
    }
    
    public void equipItem(int i) {
    	if (viewItem(i) instanceof Weapon)
    		equipment = (Weapon)(viewItem(i));
    }
    
    public void unequipItem() {
    	equipment = null;
    }
    
    public void setStatus(String newStatus) {
    	status = newStatus;
    }
    
    public void statusEffect(){
    	if (status == "Poison")
    		if (currHP < 5)
    			currHP = 1;
    		else
    			currHP -= 5;
    	//else
    		// any other statuses
    }
    
    public void useItem(int index) {
    	if (inventory[index] instanceof HealingItem)
    		if (((HealingItem)inventory[index]).getUses() > 0)
	    	{
	    		currHP += ((HealingItem)inventory[index]).getHpRecov();
	    		if (currHP > fullHP)
	    			currHP = fullHP;
	    		if (status == ((HealingItem)inventory[index]).getEffect())
	    			status = null;
	    		((HealingItem)inventory[index]).setUses(((HealingItem)inventory[index]).getUses()-1);// decrement the number of uses
	    		if (((HealingItem)inventory[index]).getUses() == 0)
	    			inventory[index] = null;
	    	}
    //	else
    		// other kinds of items
    }
    
    public void level() {
    	exp = 0;
    	if ((int)(Math.random()*100) < (hpGrowth*100))
    		fullHP++;
    	if ((int)(Math.random()*100) < (strGrowth*100))
    		str++;
    	if ((int)(Math.random()*100) < (sklGrowth*100))
    		skl++;
    	if ((int)(Math.random()*100) < (spdGrowth*100))
    		spd++;
    	if ((int)(Math.random()*100) < (lckGrowth*100))
    		lck++;
    	if ((int)(Math.random()*100) < (resGrowth*100))
    		res++;
    	currHP = fullHP;
    }
    
    public int getX() {
    	return xLocation;
    }
    
    public int getY() {
    	return yLocation;
    }
    
    public void setXLocation(int x) {
    	xLocation = x;
    }
    
    public void setYLocation(int y) {
    	yLocation = y;
    }
    
    public double[] getGrowthRates() { // order is hp, str, skl, spd, lck, def, res
    	double[] gr = {hpGrowth, strGrowth, sklGrowth, spdGrowth, lckGrowth,defGrowth, resGrowth};
    	return gr;
    }
    
    public int[] getStats() { 
	    int[] stats = {currHP, fullHP, str , skl, spd, lck, def, res, con, mov};
	    return stats;
    }
    
    public int getLevel() {
    	return level;
    }
    
    // accessor methods for each stat: currHP, fullHP, str , skl, spd, lck, def, res, con
    public int getCurrentHP() {
    	return currHP;
    }
    
    public int getFullHP() {
    	return fullHP;
    }
    
    public int getStrength() {
    	return str;
    }
    
    public int getSkill() {
    	return skl;
    }
    
    public int getSpeed() {
    	return spd;
    }
    
    public int getLuck() {
    	return lck;
    }
    
    public int getDefense() {
    	return def;
    }
    
    public int getResistance() {
    	return res;
    }
    
    public int getConstitution() {
    	return con;
    }
}