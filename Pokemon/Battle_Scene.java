/**
 * @(#)Battle Scene.java
 *
 *
 * @author 
 * @version 1.00 2015/6/2
 */

/*
	topBorder1
	enemyStatus		enemyImage
	botBorder1
	
	topBorder2
	allyStatus		allyImage
	botBorder2
	
	optionsPanel
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;

public class Battle_Scene {
	
	private int width = 400;
	private int height = 500;
	private int attackSet; // double digit # with 10's being the ally and 1's being the enemy
	private int Pokemon[] mine, opponent;
	
	private JFrame frame;
	private JPanel panel;
	private JLabel topBorder1, botBorder1, topBorder1, botBorder2;
	private JPanel enemyStatus, allyStatus;
	private JPanel enemyPanel, myPanel;
	
	private JPanel optionsPanel;
	
	private JButton moves, bag, pokemon, run;
	private JButton[] moveset;
	private JButton[] bag;
	private JButton[] pokemon;

    public Battle_Scene(Player p, Opponent o) {
    	
    	//set up the frame
    	frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	// instantiate the components
    	panel = new JPanel(new GridLayout(3,1));
    	panel.setPreferredSize(new Dimension(width,height));
    	topBorder1 = new JLabel("***********************************************************");
    	topBorder2 = new JLabel("***********************************************************");
    	botBorder1 = new JLabel("***********************************************************");
    	botBorder2 = new JLabel("***********************************************************");
    	
    	enemyStatus = new JPanel(new GridLayout(1,2));
    	sllyStatus = new JPanel(new GridLayout(1,2));
    	
    	innerEnemyPanel = new JPanel(new GridLayout(2,1));
    	innerAllyPanel = new JPanel(new GridLayout(2,1));
    	enemyPanel = new JPanel(new GridLayout(3,1));
    	allyPanel = new JPanel(new GridLayout(3,1));
    	
    	optionsPanel = new JPanel();
    	
    	// instantiate the buttons
    	
    	// 
    	
    	// create the ActionListeners for the Buttons
    	
    	// add the components to the enemyPanel, allyPanel, and optionsPanel
    	enemyPanel.add(topBorder1);
    	innerEnemyPanel.add(enemyStatus);
    	innerEnemyPanel.add(image1);
    	enemyPanel.add(innerEnemyPanel);
    	enemyPanel.add(botBorder1);
    	
    	allyPanel.add(topBorder2);
    	innerAllyPanel.add(image2);
    	innerAllyPanel.add(allyStatus);
    	allyPanel.add(innerAllyPanel);
    	allyPanel.add(botBorder2);
    	
    	// add to the panel
    	panel.add(enemyPanel);
    	panel.add(allyPanel);
    	panel.add(optionsPanel);
    	
    	// add panel to frame
    	frame.setContentPane(panel);
    	
    }
    
    private void attack(attackSet)
    {
    	
    }
    
     public void display()
    {
    	frame.pack();
    	frame.show();
    }
    
    public static void main(String arg[])
    {
    	final Battle_Scene bs = new BattleScene();
    	bs.display();
    }
    
    
}