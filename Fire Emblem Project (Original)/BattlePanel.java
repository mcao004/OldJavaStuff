// Marvin Cao
// 6/13/15

 
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;

public class BattlePanel extends JPanel{ // panel that displays before the battle and shows you the statistics of how it could go
	
	private static String doubleHit = "x2";
	private static Color allyColor = new Color(70,130,180);
	private static Color enemyColor = Color.RED;
	private static Color neutralColor = new Color(78,68,3);
	
	private boolean youAttFirst;
	
	private JPanel StatsLabels = new JPanel(new GridLayout(4,1));
	private JLabel HP = new JLabel("HP");
	private JLabel Mt = new JLabel("Mt");
	private JLabel Hit = new JLabel("Hit");
	private JLabel Crit = new JLabel("Crit");
	private JPanel overallStats = new JPanel(new GridLayout(1,3));
	
	private JLabel allyName;
	private JPanel allyStats;
	private int[] myStats;
	private JLabel myHP;
	private int allyHit;
	private JLabel myHit;
	private int allyDmg;
	private JLabel myDmg;
	private int allyCrit;
	private JLabel myCrit;
	private boolean myDoubleHit;
	private Weapon allyWep;
	
	private JLabel enemyName;
	private JPanel enemyStats;
	private JLabel enemyWeapon;
	private int[] theirStats;
	private JLabel theirHP;
	private int enemyHit;
	private JLabel theirHit;
	private int enemyDmg;
	private JLabel theirDmg;
	private int enemyCrit;
	private JLabel theirCrit;
	private boolean theirDoubleHit;
	private Weapon enemyWep;

	private JPanel allyTopPanel;
	private JPanel enemyBotPanel;
	private JPanel enemyWepPanel;
	
    public BattlePanel(Unit ally, Unit enemy, boolean youInitiate) {
    	setLayout(new GridLayout(4,1));
    	youAttFirst = youInitiate;
    	// instantiate labels and panels;
    	allyName = new JLabel(ally.getName());
    	enemyName = new JLabel(enemy.getName());
    	enemyWep = enemy.getEquipment();
    	enemyWeapon = new JLabel(enemyWep.getName());
    	myStats = ally.getStats(); // order is currHP, fullHP, str , skl, spd, lck, def, res, con, mov
    	theirStats = enemy.getStats();
    	allyStats = new JPanel(new GridLayout(4,1));
    	enemyStats = new JPanel(new GridLayout(4,1));
    	allyTopPanel = new JPanel();
    	enemyBotPanel = new JPanel();
    	enemyWepPanel = new JPanel();
    	
    	// calculate the hp, hit, dmg, crit, doublehit
    	allyHit = calcHit(ally,enemy);
    	allyDmg = calcMt(ally,enemy);
    	allyCrit = calcCrit(ally,enemy);
    	myDoubleHit = doubleAtt(ally,enemy);
    		
    	enemyHit = calcHit(enemy,ally);
    	enemyDmg = calcMt(enemy,ally);
    	enemyCrit = calcCrit(enemy,ally);
    	theirDoubleHit = doubleAtt(enemy,ally);
    	
    	// put the hit, dmg, crit in jLabels
    	myHP = new JLabel(Integer.toString(ally.getCurrentHP()));
    	myHit = new JLabel(Integer.toString(allyHit));
    	if (myDoubleHit)
    		myDmg = new JLabel(Integer.toString(allyDmg) + doubleHit);
    	else 
    		myDmg = new JLabel(Integer.toString(allyDmg));
    	myCrit = new JLabel(Integer.toString(allyCrit));
    	
    	theirHP = new JLabel(Integer.toString(enemy.getCurrentHP()));
    	theirHit = new JLabel(Integer.toString(enemyHit));
    	if (theirDoubleHit)
    		theirDmg = new JLabel(Integer.toString(enemyDmg) + doubleHit);
    	else 
    		theirDmg = new JLabel(Integer.toString(enemyDmg));
    	theirCrit = new JLabel(Integer.toString(enemyCrit));
    	// set the color of all the labels and panels
    	HP.setBackground(neutralColor);
    	Mt.setBackground(neutralColor);
    	Hit.setBackground(neutralColor);
    	Crit.setBackground(neutralColor);
    	StatsLabels.setBackground(neutralColor);
    	
    	myHP.setBackground(allyColor);
    	myHit.setBackground(allyColor);
    	myDmg.setBackground(allyColor);
    	myCrit.setBackground(allyColor);
    	allyStats.setBackground(allyColor);
    	allyName.setBackground(allyColor);
    	allyTopPanel.setBackground(allyColor);
    	
    	enemyStats.setBackground(enemyColor);
    	theirHP.setBackground(enemyColor);
    	theirHit.setBackground(enemyColor);
    	theirDmg.setBackground(enemyColor);
    	theirCrit.setBackground(enemyColor);
    	enemyName.setBackground(enemyColor);
    	enemyWeapon.setBackground(enemyColor);
    	enemyBotPanel.setBackground(enemyColor);
    	enemyWepPanel.setBackground(enemyColor);
    	// create the interior statslabels
    	StatsLabels.add(HP);
    	StatsLabels.add(Mt);
    	StatsLabels.add(Hit);
    	StatsLabels.add(Crit);
    	// create the interior of allystats
    	allyStats.add(myHP);
    	allyStats.add(myHit);
    	allyStats.add(myDmg);
    	allyStats.add(myCrit);
    	
    	enemyStats.add(theirHP);
    	enemyStats.add(theirHit);
    	enemyStats.add(theirDmg);
    	enemyStats.add(theirCrit);
    	
    	overallStats.add(enemyStats);
    	overallStats.add(StatsLabels);
    	overallStats.add(allyStats);
    	
    	allyTopPanel.add(); // ally wep image
    	allyTopPanel.add(allyName);
    	enemyWepPanel.add(enemyWeapon);
    	enemyBotPanel.add(); // enemy wep image
    	enemyBotPanel.add(enemyName);
    	
    	// add all of it to the battlepanel
    	add(allyName);
    	add(overallStats);
    	add(enemyName);
    	add(enemyWeapon);
    }
    
    public static void main(String[] args){
    	JFrame frame = new JFrame("Test");
    	frame.setCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Unit Eirika = Unit.Eirika;
    	Eirika.getItem(Weapon.Rapier);
    	Eirika.equipItem(0);
		Eirika.getItem(HealingItem.Vulnerary);
		Unit ONeil = Unit.ONeil;
		ONeil.getItem(Weapon.IronAxe);
		ONeil.equipItem(0);
    	
    	frame.add(new BattlePanel(Unit.Eirika ,Unit.ONeil , true));
    	frame.pack();
    	frame.show();
    }
    
    public int calcHit(Unit attacker, Unit defender) {
    	
    	Weapon attWep = attacker.getEquipment();
    	Weapon defWep = defender.getEquipment();
    	if (attWep == null)
    		return 0;
    	
    	// weapon triangle bonus advantages
    	int wtbonus = 0;
    	if (attWep.getWepClass() == "Sword")
    		if (defWep.getWepClass() == "Axe")
    			wtbonus = 15;
    		else if (defWep.getWepClass() == "Lance")
    			wtbonus = -15;
    	else if (attWep.getWepClass() == "Axe")
    		if (defWep.getWepClass() == "Sword")
    			wtbonus = -15;
    		else if (defWep.getWepClass() == "Lance")
    			wtbonus = 15;
    	else if (attWep.getWepClass() == "Lance")
    		if (defWep.getWepClass() == "Sword")
    			wtbonus = 15;
    		else if (defWep.getWepClass() == "Axe")
    			wtbonus = -15;
    	else // other weapons such as tomes bows knives etc.
    		wtbonus = 0;
    	int supportBonus = 0; // I am not giving you any support
    	
    	int attackSpeed = attacker.getSpeed() - (attWep.getWeight() - attacker.getConstitution());
    	if (attackSpeed < 0)
    		attackSpeed = 0;
    	
    	int SRankBonus;
    	if (attWep.getWeaponLevel() == 'S') //S Rank Bonus Determination
    		SRankBonus = 5;
    	else
    		SRankBonus = 0;
    		
    	int terrainBonus = 0; // only on grass at the moment
    		
    	int accuracy = attWep.getHit() + (attacker.getSkill()) + (attacker.getLuck()/2) + supportBonus + wtbonus + SRankBonus ;
    	int avoid = (attackSpeed * 2) + defender.getLuck() + supportBonus + terrainBonus;
    	return accuracy - avoid;
    	
    }
 // ACCURACY
 // wep triangle bonus for acc = +15 if good against, -15 if bad
 // S Rank bonus: 5 if user is equipped with a weapon, whose weapon type they have an S Rank in
 // accuracy = Weapon Hit + (Skill x 2) + (Luck / 2) + Support bonus + Weapon triangle bonus + S Rank bonus
 // attack spd = Speed - (Weapon Weight - Constitution, take as 0 if negative) [Minimum is 0] 
 // avoid = (Attack Speed x 2) + Luck + Support bonus + Terrain bonus
 // battle acc = Accuracy - enemy's Avoid
    
    public int calcMt(Unit attacker, Unit defender) { // calculating the might the weapon will have on the enemy
    	Weapon attWep = attacker.getEquipment();
    	if (attWep == null)
    		return 0;
    	String attackType;
    	if (attWep.getWepClass() == "Sword" || attWep.getWepClass() == "Axe" || attWep.getWepClass() == "Lance")
    		attackType = "Physical Direct";
    	else if (attWep.getWepClass() == "Bow" || attWep.getWepClass() == "Ranged-Sword")
    		attackType = "Physical Ranged";
    	else if (attWep.getWepClass() == "Tome")
    		attackType = "Magic";
    	else
    		attackType = null;
    	
    	Weapon defWep = defender.getEquipment();
    	
    	// weapon triangle bonus advantages
    	int wtbonus = 0;
    	if (attWep.getWepClass() == "Sword") // attacker
    		if (defWep.getWepClass() == "Axe") // defender
    			wtbonus = 1;
    		else if (defWep.getWepClass() == "Lance") //defender
    			wtbonus = -1;
    	else if (attWep.getWepClass() == "Axe") // attacker
    		if (defWep.getWepClass() == "Sword") //defender
    			wtbonus = -1;
    		else if (defWep.getWepClass() == "Lance") //defender
    			wtbonus = 1;
    	else if (attWep.getWepClass() == "Lance") // attacker
    		if (defWep.getWepClass() == "Sword") // defender
    			wtbonus = 1;
    		else if (defWep.getWepClass() == "Axe") //defender
    			wtbonus = -1;
    	else // other weapons such as tomes bows etc.
    		wtbonus = 0;
    	int effBonus = 1; // not that many different types yet
    	int supportBonus = 0; // no support yet
    	
    	int might;
    	switch (attackType) {
    		case "Physical Direct":
    			might = attacker.getStrength() + ((attWep.getMight() + wtbonus) * effBonus) + supportBonus;
    			break;
    		case "Physical Ranged":
    			might = (attacker.getStrength()/2) + ((attWep.getMight() + wtbonus) * effBonus) + supportBonus;
    			break;
    		case "Magic":
    			might = attacker.getStrength() + ((attWep.getMight() + wtbonus) * effBonus) + supportBonus; // strenght is actually magic in this case
    			break;
    		default:
    			might = 0;
    			break;
    	}
    	
    	int physicalDefense, magicalDefense;
    	supportBonus = 0; // no support yet
    	int terrainBonus = 0; // still only grass
    	physicalDefense = defender.getDefense() + supportBonus + terrainBonus;
    	magicalDefense = defender.getResistance() + supportBonus + terrainBonus;
    	// overall dmg = (Attack - enemy Defence) x Critical bonus
    	// assumed crit bonus of 1
    	int critBonus = 1;
    	switch (attackType) {
    		case "Physical Direct":
    			return might - physicalDefense;
    		case "Physical Ranged":
    			return might - physicalDefense;
    		case "Magic":
    			return might - magicalDefense;
    		default:
    			return 0;
    	}
    }
     // ATT
 // wep triangle bonus = +1 if better, 0 if neutral, -1 if worse
 // effective bonus = 3 if good against enemy type, 1 if not
 // physical direct att = Strength + [(Weapon might + Weapon triangle bonus) x Effective bonus] + Support bonus 
 // physical indirect att = (Strength / 2) + [(Weapon might + Weapon triangle bonus) x Effective bonus] + Support bonus
 // magical att = Magic + [(Weapon might + Weapon triangle bonus) x Effective bonus] + Support bonus
 
 // DEF
 // physical = Defence + Support bonus + Terrain bonus
 // magical = Resistance + Support bonus + Terrain bonus

    
    public int calcCrit(Unit attacker, Unit defender) {
    	Weapon attWep = attacker.getEquipment();
    	if (attWep == null)
    		return 0;
    	Weapon defWep = defender.getEquipment();
    	
    	int SRankBonus;
    	if (attWep.getWeaponLevel() == 'S') //S Rank Bonus Determination
    		SRankBonus = 5;
    	else
    		SRankBonus = 0;
    	
    	// classes with crit bonuses
    	int critBonus;
    	if (attacker.getUnitClass() == "Swordmaster" || attacker.getUnitClass() == "Berserker" || attacker.getUnitClass() == "Journeyman(3)" || attacker.getUnitClass() == "Recruit(3)")	
    		critBonus = 15;
    	else
    		critBonus = 0;
    	
    	int supportBonus = 0;
    	
    	int critRate = attWep.getCrit() + (attacker.getSkill() / 2) + supportBonus + critBonus + SRankBonus;
    	int critEvade = defender.getLuck() + supportBonus;
    	int crit = critRate - critEvade;
    	if (crit < 0)
    		return 0;
    	else
    		return crit;
    }
     // CRIT
 // S Rank bonus: 5 if user is equipped with a weapon, whose weapon type they have a S Rank in
 // Critical bonus: 15 if user is a Swordmaster, Berserker, Journeyman (3) or Recruit (3)
 // crit rate = Weapon Critical + (Skill / 2) + Support bonus + Critical bonus + S Rank bonus
 // crit evade = Luck + Support bonus
 // batt crit rate = Critical rate - enemy's Critical evade
 // crit bonus = 3 if done

    
    public boolean doubleAtt(Unit attacker, Unit defender) {
    	Weapon attWep = attacker.getEquipment();
    	Weapon defWep = defender.getEquipment();
    	
    	int attackSpeed = attacker.getSpeed() - (attWep.getWeight() - attacker.getConstitution());
    	if (attackSpeed < 0)
    		attackSpeed = 0;
    		
    	int enAttackSpeed = defender.getSpeed() - (defWep.getWeight() - defender.getConstitution());
    	if (enAttackSpeed < 0)
    		enAttackSpeed = 0;
    	return (attackSpeed - enAttackSpeed >= 4);
    } // DOUBLE ATTACK
 // attack spd = Speed - (Weapon Weight - Constitution, take as 0 if negative) [Minimum is 0] 
 // double att if  (Attack Speed - enemy Attack Speed) >= 4
    
}