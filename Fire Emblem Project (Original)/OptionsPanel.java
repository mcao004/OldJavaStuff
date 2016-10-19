/**
 * @(#)OptionsPanel.java
 *
 *
 * @author 
 * @version 1.00 2015/6/5
 */
 // incomplete
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;

public class OptionsPanel extends JPanel
{
    JButton attackButton, healButton, itemButton, waitButton;
    
    public OptionsPanel() {
    	setLayout(new GridLayout(4,1));
    	attackButton = new JButton("Attack");
    	attackButton.addActionListener(new ActionListener()
    	{
	    	public void actionPerformed (ActionEvent e){
	    		
	    	}
    	});
    	healButton = new JButton("Heal");
    	healButton.addActionListener(new ActionListener()
    	{
    		public void actionPerformed (ActionEvent e){
	    		
	    	}
    	});
    	itemButton = new JButton("Items");
    	itemButton.addActionListener(new ActionListener()
    	{
    		public void actionPerformed (ActionEvent e){
	    		
	    	}
    	});
    	waitButton = new JButton("Wait");
    	waitButton.addActionListener(new ActionListener()
    	{
    		public void actionPerformed (ActionEvent e){
	    		
	    	}
    	});
    	
    	add(attackButton);
    	add(healButton);
    	add(itemButton);
    	add(waitButton);
    }
    
    
    
}