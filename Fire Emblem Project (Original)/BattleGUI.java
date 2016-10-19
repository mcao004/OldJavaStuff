/**
 * @(#)BattleGUI.java
 *
 *
 * @author 
 * @version 1.00 2015/6/8
 */
 // incomplete
 // attacking formulas
 
 // DOUBLE ATTACK
 // attack spd = Speed - (Weapon Weight - Constitution, take as 0 if negative) [Minimum is 0] 
 // double att if  (Attack Speed - enemy Attack Speed) >= 4
 
 // ATT
 // wep triangle bonus = +1 if better, 0 if neutral, -1 if worse
 // effective bonus = 3 if good against enemy type, 1 if not
 // physical direct att = Strength + [(Weapon might + Weapon triangle bonus) x Effective bonus] + Support bonus 
 // physical indirect att = (Strength / 2) + [(Weapon might + Weapon triangle bonus) x Effective bonus] + Support bonus
 // magical att = Magic + [(Weapon might + Weapon triangle bonus) x Effective bonus] + Support bonus
 
 // DEF
 // physical = Defence + Support bonus + Terrain bonus
 // magical = Resistance + Support bonus + Terrain bonus
 
 // CRIT
 // S Rank bonus: 5 if user is equipped with a weapon, whose weapon type they have a S Rank in
 // Critical bonus: 15 if user is a Swordmaster, Berserker, Journeyman (3) or Recruit (3)
 // crit rate = Weapon Critical + (Skill / 2) + Support bonus + Critical bonus + S Rank bonus
 // crit evade = Luck + Support bonus
 // batt crit rate = Critical rate - enemy's Critical evade
 // crit bonus = 3 if done
 // overall dmg = (Attack - enemy Defence) x Critical bonus
 
 // ACCURACY
 // wep triangle bonus for acc = +15 if good against, -15 if bad
 // S Rank bonus: 5 if user is equipped with a weapon, whose weapon type they have an S Rank in
 // accuracy = Weapon Hit + (Skill x 2) + (Luck / 2) + Support bonus + Weapon triangle bonus + S Rank bonus
 // avoid = (Attack Speed x 2) + Luck + Support bonus + Terrain bonus
 // battle acc = Accuracy - enemy's Avoid
 
 // EXP
 //Class power: 1 for Journeyman (1), Recruit (1), Pupil (1), Civilian, Pontifex and Entombed, 2 for Cleric, Soldier, Troubadour, Manakete (M), Manakete (F), Thief, Priest and Dancer, 5 for Demon King, 3 for everything else.
 //Class bonus A: 0 for non-promoted classes, 20 for promoted classes.
 //Class bonus B: 0 for non-promoted classes, 40 for Assassins, Rogues, Bishops and Valkyries, 60 for all other promoted classes.
 //Mode coefficient: Initially treat this value as being 1. If Experience from defeating (base) is calculated as 0 or negative, this value becomes 2 instead. For all other cases it remains 1.
 //Boss bonus: 40 if enemy is a boss, 0 if not.
 //Thief bonus: 20 if enemy is a Thief, Rogue or Assassin, 0 if not.
 //Silencer bonus: ~1.8 if the user activates Silencer, 1 if not.
 // exp doing dmg  = [31 + (enemy's Level + enemy's Class bonus A) - (Level + Class bonus A)] / Class power
 // exp no dmg = 1
 // exp defeating  = [(enemy's Level x enemy's Class power) + enemy's Class bonus B] - { [(Level x Class power) + Class bonus B] / Mode coefficient }
 // exp defeating enemy  = [Experience from doing damage + (Experience from defeating (base) + 20 + Boss bonus + Thief bonus, take as 0 if negative)] x Silencer bonus


public class BattleGUI {
	
	
    public BattleGUI(Unit ally, Unit enemy, boolean youInitiate) {
    	
    }
    
    private void checkIfDead() { // done each time someone attacks
    	
    }
    
    private void allyAttack() {
    	
    }
    
    private void enemyAttack() {
    	
    }
    
    
}