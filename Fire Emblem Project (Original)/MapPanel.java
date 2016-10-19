/**
 * @(#)MapPanel.java
 *
 *
 * @author
 * @version 1.00 2015/6/5
 */
 // incomplete
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MapPanel extends JPanel{

   private GridBagConstraints gbc = new GridBagConstraints();
   ArrayList components;
   ArrayList <Unit> units;
   boolean unitSelected = false;
    
    public static void main(String[] args){
    	JFrame frame = new JFrame("Test");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(new MapPanel());
    	frame.pack();
    	frame.show();
    }
    

        public MapPanel() { // constructor
            components = new ArrayList();
            units = new ArrayList();
            setLayout(new GridBagLayout());
            addMouseListener(new MouseAdapter() {
            	@Override
                public void mouseClicked(MouseEvent e) {
                	GridBagLayout gbl = new GridBagLayout();
                	int x = getX();
                	int y = getY();
                	GridBagConstraints g = new GridBagConstraints();
                	GrassPane match = null;
                for (Object comp: components){ // check all components
                	if (comp instanceof GrassPane) 
	                g = gbl.getConstraints((Component)comp); //store its constraints in g
				    if (g.gridx == x && g.gridy == y) {
				        match = (GrassPane)comp; // store the grasspane in match
				        break;
				    }
                }
                	if ((match.getComponent(0)) instanceof JLabel){
                		for (int i = 0; i < units.size(); i++)
                			if (units.get(i).showUnitDisplay() == ((JLabel)(match.getComponent(0))).getIcon()){
                				mouseClickOnUnit(units.get(i));
                				break;
                			}
                	}
                	else
                		displayMapOptions();	
                }
            });

            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 20; col++) {
           //         gbc.weightx = 0.05;
           //         gbc.weighty = 0.05;
                    gbc.gridx = col;
                    gbc.gridy = row;

                    GrassPane grass = new GrassPane(col, row);
                    components.add(grass);
                    
                    add(grass, gbc);
                }
            }
        }
        
        public void addUnitToMap(Unit u, int x, int y){
	    	JLabel unitlabel = new JLabel(u.showUnitDisplay());
	    	GridBagLayout gbl = new GridBagLayout();
	    	u.setXLocation(x);
	    	u.setYLocation(y);
	    	gbc.gridx = x;
	    	gbc.gridy = y;
	    	components.add(unitlabel);
	    	for (Object obj : components) { // for each component in arraylist components
	    		if (obj instanceof Component) {
	    			if (gbl.getConstraints((Component)obj).gridx == x && gbl.getConstraints((Component)obj).gridy == y) // if obj(GrassPane) has same coordinates as the new location
	    				((GrassPane)obj).add(unitlabel);
	    		}
	    	}
	    	add(unitlabel, gbc);
	    	units.add(u);
	    	
	    }

        
        public void mouseClickOnUnit(Unit u) {
        	unitSelected = true;
        	
        	int mov = u.getMovement();
           	highlightAttackRange(u,mov,1);
           	highlightPaths(u,mov);
        }
        
        public void displayMapOptions(){
        	JFrame f = new JFrame();
        	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // not done yet
        }
        
        public void highlightPaths(Unit u, int movement) { // use the unit's location and change the foreground color of the tiles it can reach in one turn
        	GridBagLayout gbl = (GridBagLayout)getLayout();
        	int x = u.getX(); // recorded x location
        	int y = u.getY(); // recorded y location
        	GridBagConstraints g = gbl.getConstraints(u);// the tile he is displayed on
        	int[][] grid = gbl.getLayoutDimensions(); 
        	for (int i = 0; i < movement; i++){ // use the movement to highlight the tiles if in movement range
     //   		if ()
        	}
        	for (int row = 0; row < 20; row++) { // scanning through all the tiles in the grid to find the tiles that are within the range of movement
                if (row < y + movement && row > y - movement) // limiters from top to bottom of movement possibilities
                for (int col = 0; col < 20; col++) {
                	if (col < x + movement && row > x - movement){ // limiters from left to right on movement
                		for (Object comp: components){ // checks each component in the list
		                	if (comp instanceof Component) // if a component
			                g = gbl.getConstraints((Component)comp); // grab its constraints
						    if (g.gridx == x && g.gridy == y) { // same constraints as those above
						        ((GrassPane)comp).highlightAsMVRange();
						        break;
						    }
		                }
                	}
                }
        	}
        	
        //	for () // for each amount of movement 1,..., mv, highlight(change foreground color temporarily) the tiles that the unit can move
        }
        
        public void highlightAttackRange(Unit u,int movement, int attackRange) {
        	GridBagLayout gbl = (GridBagLayout)getLayout();
        	GridBagConstraints g = gbl.getConstraints(u);
        	int x = u.getX();
        	int y = u.getY();
        	int[][] grid = gbl.getLayoutDimensions();
        	for (int i = movement; i < (movement + attackRange); i ++){
        		
        	}
        	for (int row = 0; row < 20; row++) { // scanning through all the tiles in the grid to find the tiles that are within the range of movement
                if (row < y + movement + attackRange && row > y - (movement + attackRange)) // limiters from top to bottom of movement possibilities
                for (int col = 0; col < 20; col++) {
                	if (col < x + movement + attackRange && row > x - (movement + attackRange)){ // limiters from left to right on movement
                		for (Object comp: components){ // checks each component in the list
		                	if (comp instanceof Component) // if a component
			                g = gbl.getConstraints((Component)comp); // grab its constraints
						    if (g.gridx == x && g.gridy == y) { // same constraints as those above
						        ((GrassPane)comp).highlightAsMVRange();
						        break;
						    }
		                }
                	}
                }
        	}
        }
        
        public void moveUnit(Component c, int newX, int newY){
        	GridBagLayout gbl = new GridBagLayout();
        	GridBagConstraints g1 = new GridBagConstraints(); // for new
        	GridBagConstraints g2 = new GridBagConstraints(); // for old
        	g2.gridx = gbl.getConstraints(c).gridx;
        	g2.gridy = gbl.getConstraints(c).gridy; // save the old in g2
        	g1.gridx = newX;
        	g1.gridy = newY; // save the new into the new Constraints
        	gbl.setConstraints(c,g1); // put the old component into the new location
        	GrassPane grass = new GrassPane(g2.gridx, g2.gridy); // create a replacement grasspane; 
        	components.add(grass); // add it to the list of components
        	add(grass,g2); // add the grasspane to the old location
        }
         // end of map class
        
    

    public class GrassPane extends JPanel { // a single panel on the map

        private Color defaultBackground = new Color(124,252,0,122);
        private Border defaultBorder = new MatteBorder(1,1,1,1, new Color (192,192,192));
        private Border cursoredBorder = new MatteBorder(1,1,1,1, new Color (32,32,32));
        private int x;
        private int y;
        private boolean mvHighlighted;
        private Color mvHighlight = new Color(153,255,255,122);
        private boolean attHighlighted;
        private Color attHighlight = new Color(255,51,51,122);
        private Color transparent = new Color(0,0,0,0);

        public GrassPane(int x,int y) {
        	this.x = x;
        	this.y = y;
        	setBackground(defaultBackground);
        	setBorder(defaultBorder);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) { // change color of the border around the tile the mouse is on
                  setBorder(cursoredBorder);
                  /*  defaultBackground = getBackground();
                    setBackground(Color.BLUE);*/
                }
                
                public void mouseClicked(MouseEvent e) { // 
                //	e.getSource().getParent();
                }

                @Override
                public void mouseExited(MouseEvent e) { // change the color of the border back to its original
                    setBorder(defaultBorder);
        //            setBackground(defaultBackground);
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(24, 24);
        }
        
        public void setx(int x){
        	this.x = x;
        }
        
        public void sety(int y) {
        	this.y = y;
        }
        
        public int getx() {
        	return x;
        }
        
        public int gety() {
        	return y;
        }
        
        public void highlightAsMVRange(){
        	setForeground(mvHighlight);
        	mvHighlighted = true;
        }
        
        public void revertFromMVRange() {
        	setForeground(transparent);
        	mvHighlighted = false;
        }
        
        public void highlightAsAttRange() {
        	setForeground(attHighlight);
        	attHighlighted = true;
        }
        
        public void revertFromAttRange() {
        	setForeground(transparent);
        	attHighlighted = false;
        }
    } // end of grasspane class
}