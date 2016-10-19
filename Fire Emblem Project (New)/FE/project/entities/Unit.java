package FE.project.entities;

import FE.project.*;
import FE.project.entities.*;
import FE.project.entities.items.*;

public abstract class Unit extends Entity {
	
	public static int DEFAULT_WIDTH = 16,
					  DEFAULT_HEIGHT = 16;
	
	public String name, className;
	public FEItem[] inventory = new FEItem[5];
	public Weapon equipment;
	public String affinity;
	public String weaponTypes;
	private int level, currHP, fullHP, str , skl, spd, lck, def, res, con, mov; // strength/magic, skill, speed, luck, resistance, constitution, movement
	private double hpGrowth, strGrowth, sklGrowth, spdGrowth, lckGrowth,defGrowth, resGrowth; // growth rates
	private int exp;
	private char capableWeaponLevel;
	private String status;
	private ArrayList<Tile> movementTiles = new ArrayList<Tile>();
	
	public Unit(Game game, float x, float y, String n, String c, String affin, int lvl, int HP, int st, int sk, int sp, int lk,int df,
				int rs, int cn, int mv, double hpg, double stg, double skg, double spg, double lkg,double  dfg, double rsg, char cWPLVL){
		super(game,x,y,DEFAULT_WIDTH, DEFAULT_HEIGHT);
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
	}
	
	public Weapon getEquipment() {
    	return equipment;
    }
    
    public FEItem[] getInventory() {
    	return inventory;
    }
    
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
    
    public String getName() {
    	return name;
    }
    
    public String getClassName() {
    	return className;
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
    
    public int getMovement() {
    	return mov;
    }
    
    public World getWorld() {
    	return this.game.getGameState().getWorld();
    }
    
    // don't use until modified
  /*  public ArrayList<Tile> getMovementTiles() {
    	movementTiles = new ArrayList<Tile>();
    	World ourWorld = this.getWorld();
    	movementTiles.add(ourWorld.getTile(this.getX(), this.getY()));
    	
    	// Reset dist and visited for all Tiles
    	for( int i = 0; i < ourWorld.width - 1; i++ ) {
    		for( int j = 0; j < ourWorld.height - 1; j++ ) {
    			ourWorld.Tiles[i][j].dist = -1;
    			ourWorld.Tiles[i][j].visited = false;
    		}
    	}
    	
    	ConcurrentLinkedQueue<Tile> q = new ConcurrentLinkedQueue();
    	q.push(ourWorld.getTile(this.getX(), this.getY());
    	ourWorld.getTile(this.getX(), this.getY()).dist = 0;
    	while( !q.empty() ) {
    		Tile k = q.pop();
    		k.visited = true;
    		Tile[] adjacencies = ourWorld.getAdjacentTiles(this.getX(), this.getY());
    		for( int i = 0; i < adjacencies.length; i++) {
    			if( Tile[i] != null && 
    				Tile[i].visited == false && 
    				Tile[i].dist == -1 &&
    				Tile[i].dist + 1 > this.movement) {
    				
    				q.push(Tile[i]);
    				movementTiles.add(Tile[i]);
    				Tile[i].dist = k.dist + 1;
    			}//dijkstra's
    		}
    		
    	}
    	
    	return movementTiles;
    }*/
}
