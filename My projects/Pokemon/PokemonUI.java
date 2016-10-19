/*
 Marvin Cao
 5/21/2015
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PokemonUI extends JFrame
{
    JFrame frame;
    
    
    public PokemonUI() 
    {
    	frame = new JFrame("Pokemon Games");
	    frame.setPreferredSize(new Dimension(100,200));
	    frame.setIconImage(new Image())
	    frame.setContentPane(new Map());
	    frame.setLayout(new GridLayout());
    }
    
    
}