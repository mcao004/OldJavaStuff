/**
 * @(#)Player.java
 *
 *
 * @author 
 * @version 1.00 2015/6/2
 */
import java.util.ArrayList;

public class Player {
	
	int gender;// 0 for girl, 1 for boy
	Pokemon[] myPokSet;
	Badges[] badgeSet;
	ArrayList[] Bag;
	ArrayList<Item> KeyItems;
	ArrayList<Item> Pokeballs;
	ArrayList<Item> Miscellaneous;
	ArrayList<Item> TMandHM;
	ArrayList<Item> Berries;
	
	
    public Player(int num) 
    {
    	gender = num;
    	myPokSet = {null, null, null, null, null, null};
    	badgeSet = {null, null, null, null, null, null};
    	KeyItems = null;
    	Pokeballs = null;
    	Miscellaneous = null;
    	TMandHM = null;
    	Berries = null;
    	Bag = {Miscellaneous, Berries, Pokeballs, TMandHM, KeyItems};
    }
    
    
}