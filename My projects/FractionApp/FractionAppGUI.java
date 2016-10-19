// Marvin Cao
// 5/27/2015
/**
 Fraction App
Design an application that uses swing GUI components to add, subtract, multiply, and divide fractions.
Use the Rational class (or MyRational) from LLC chapter 4.
Minimally, you should incorportate frames, labels, textboxes, buttons as components.
Criteria:
Uses a working GUI with Frames, Panels, Layout Manager, and assorted components.
create  inner class which implements an ActionListener for event handling for each function (adding, subtracting, multiplying and dividing)
Use the Integer and String class to help with input of numbers for numerator and denominator
Try extending Frame in the fashion of the TextEditor Class Example so that you don't need a driver class.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;



public class FractionAppGUI {

    private int width = 300;
    private int height = 200;
    private Rational num1, num2, result;
    private int operation; // 1 for add, 2 subtract, 3 mult, 4 divide

    private JFrame frame;
    private JPanel panel, entryPanel, buttonPanel, addPanel, subtractPanel, multiplyPanel, dividePanel, equalsPanel;
    private JLabel titleLabel;
    private JTextField numField, denField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton;



    public FractionAppGUI()
    {
    	// set up frame
    	frame = new JFrame("IT'S A FREAKING CALCULATOR!!!!");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	// components
    	titleLabel = new JLabel("Yes it is a calculator");
    	numField = new JTextField("numerator");
    	denField = new JTextField("denominator");


    	addButton = new JButton("+");
    	addButton.addActionListener(new AddListener());
    	subtractButton = new JButton("-");
    	subtractButton.addActionListener(new SubtractListener());
    	multiplyButton = new JButton("*");
   		multiplyButton.addActionListener(new MultiplyListener());
    	divideButton = new JButton("/");
    	divideButton.addActionListener(new DivideListener());
    	equalsButton = new JButton("=");

    	// setup the panel and add the compenents
    	panel = new JPanel(new GridLayout(2,1));
    //	frame.getContentPane().setLayout(  new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS) );
    	entryPanel = new JPanel();
    	entryPanel.setBackground(Color.MAGENTA);
    	buttonPanel = new JPanel(new GridLayout(1,5));
    	buttonPanel.setBackground(Color.MAGENTA);
    	
    	addPanel = new JPanel();
    	subtractPanel = new JPanel();
    	multiplyPanel = new JPanel();
    	dividePanel = new JPanel();
    	equalsPanel = new JPanel();
    	panel.setPreferredSize(new Dimension(width,height));
    	panel.setBackground(Color.MAGENTA);
    	
    	panel.add(Box.createRigidArea (new Dimension(0,5)));
    	panel.add(titleLabel);
    	entryPanel.add(Box.createRigidArea (new Dimension(0,5)));
    	entryPanel.add(numField);
    	entryPanel.add(denField);
    	addPanel.add(addButton);
    	subtractPanel.add(subtractButton);
    	multiplyPanel.add(multiplyButton);
    	dividePanel.add(divideButton);
    	equalsPanel.add(equalsButton);
    	buttonPanel.add(addPanel);
    	buttonPanel.add(subtractPanel);
    	buttonPanel.add(multiplyPanel);
    	buttonPanel.add(dividePanel);
    	buttonPanel.add(equalsPanel);
    	panel.add(entryPanel);
    	panel.add(buttonPanel);
    	frame.setContentPane(panel);
    }

    public void display()
    {
    	frame.pack();
    	frame.show();
    }

    // inner class to handle the event
   private class AddListener implements ActionListener
    {
    	public void actionPerformed (ActionEvent event)
    	{
    		num1 = new Rational(Integer.parseInt(numField.getText()), Integer.parseInt(denField.getText()));
    		operation = 1;
    		numField.setText("");
    		denField.setText("");

    	}
    }

    private class SubtractListener implements ActionListener
    {
    	public void actionPerformed (ActionEvent event)
    	{
    		num1 = new Rational(Integer.parseInt(numField.getText()), Integer.parseInt(denField.getText()));
    		operation = 2;
			numField.setText("");
    		denField.setText("");
    	}
    }

    private class MultiplyListener implements ActionListener
    {
    	public void actionPerformed (ActionEvent event)
    	{
    		num1 = new Rational(Integer.parseInt(numField.getText()), Integer.parseInt(denField.getText()));
    		operation = 3;
			numField.setText("");
    		denField.setText("");
    	}
    }

    private class DivideListener implements ActionListener
    {
    	public void actionPerformed (ActionEvent event)
    	{
    		num1 = new Rational(Integer.parseInt(numField.getText()), Integer.parseInt(denField.getText()));
    		operation = 4;
			numField.setText("");
    		denField.setText("");
    	}
    }

    private class equalsListener implements ActionListener
    {
    	public void actionPerformed (ActionEvent event)
    	{
    		num2 = new Rational(Integer.parseInt(numField.getText()), Integer.parseInt(denField.getText()));
    		if (operation == 1)
				result = num1.add(num2);
			else if (operation == 2)
				result = num1.subtract(num2);
			else if (operation == 3)
				result = num1.multiply(num2);
			else if (operation == 4)
				result = num1.divide(num2);
			else
				result = null;
			numField.setText(Integer.toString(result.getNumerator()));
			denField.setText(Integer.toString(result.getDenominator()));
    	}
    }


	public static void main(String[] args)
	{
		final FractionAppGUI app = new FractionAppGUI();
		app.display();
	}

}