/**
 * @(#)PIgLatinTranslator.java
 *
 *
 * @author
 * @version 1.00 2015/5/20
 */

 import java.awt.*;
 import java.util.*;
 import java.awt.event.*;
 import javax.swing.*;


public class PigLatinGUI {

    private int width = 300;
    private int height = 250;
    private String sentence;
    private PigLatinTranslator pig = new PigLatinTranslator();

    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel, promptLabel, translateLabel;
    private JTextField input;
    private JTextArea textArea;

    public PigLatinGUI() {
    	// set up the frame
    	frame = new JFrame("Pig Latin Translator");
    	frame.setDefaultCloseOperation(JFrame.	EXIT_ON_CLOSE);


    	//setup the components
    	titleLabel = new JLabel("Try the Pig Translator");
    	promptLabel = new JLabel("Enter text for tranlation");
    	translateLabel = new JLabel ("Pig Latin Translation");
    	textArea = new JTextArea(5,20);
    	input = new JTextField(20);
    	input.addActionListener(new TestListener());

    	//setup the panel and add the compenents to it
    	panel = new JPanel();
    	panel.setPreferredSize(new Dimension (width,height));
    	panel.setBackground(Color.GREEN);
    	panel.add(titleLabel);
    	panel.add(promptLabel);
    	panel.add(input);
    	panel.add(translateLabel);
    	panel.add(textArea);
    	frame.setContentPane(panel);
    }

   	public void display()
   	{
   		frame.pack();
   		frame.show();
   	}

    // creat4e an inner class to handle the event
    private class TestListener implements ActionListener
    {
    	public void actionPerformed (ActionEvent event)
    	{
    		String text = input.getText();
    		textArea.setText(pig.translate(text));
    	}
    }
}