/**
 * @(#)FireEmblemGUI.java
 *
 *
 * @author
 * @version 1.00 2015/6/5
 */
 // complete but can be edited
 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;


public class FireEmblemGUI {

    private int width = 700;
    private int height = 700;

    private JFrame frame;
    private JPanel panel;
    private MapPanel map;
    private Unit Eirika, ONeil;
    private OptionsPanel options;
    
    

    public FireEmblemGUI()
    {
    	// set up frame
    	frame = new JFrame("It's Fire Emblem, muddafucka!!");
    	frame.setResizable(false);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set up smaller components
		Eirika = Unit.Eirika;
		Eirika.getItem(Weapon.Rapier);
		Eirika.getItem(HealingItem.Vulnerary);
		ONeil = Unit.ONeil;
		ONeil.getItem(Weapon.IronAxe);
    	// set up components
		map = new MapPanel();
		map.addUnitToMap(Eirika, Eirika.getX(), Eirika.getY());
		map.addUnitToMap(ONeil, ONeil.getX(), ONeil.getY());
		
		options = new OptionsPanel();
    	// set up panel and add components
		panel = new JPanel();
		panel.add(map);
		panel.add(options);
		frame.setContentPane(panel);
		
    }

    public void display()
    {
    	frame.pack();
    	frame.show();
    }


    public static void main(String[] args)
	{
		final FireEmblemGUI FEG = new FireEmblemGUI();
		FEG.display();
	}

}