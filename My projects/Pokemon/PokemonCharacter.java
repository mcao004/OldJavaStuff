/**
 * @(#)PokemonCharacter.java
 *
 *
 * @author 
 * @version 1.00 2015/5/21
 */


public class PokemonCharacter {

    int direction; // direction: 0 degrees = right, 90 = up, 180 = left, 270 = down
    boolean onBike;
    boolean onWater;
    
    public PokemonCharacter() 
    {
    	direction = 270;
    	onBike = false;
    	onWater = false;
    }
    
    public void move(int dir)
    {
    	if (dir != direction)
    		direction = dir;
    	else if ()// facing a wall or tree
    	
    	else // no obstacle
    	
    }
    
    
}