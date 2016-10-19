/**
 * @(#)Content.java
 *
 *
 * @author
 * @version 1.00 2015/5/15
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.accessibility.AccessibleContext;


public class Content extends JPanel
{
	private int num1;
	private int num2;
	private int response;
	private boolean correct;
	private static JLabel titleLabel = new JLabel("Multiplication");
    private static JLabel underTitle1 = new JLabel( "**********************************************");
    private static JLabel underTitle2 = new JLabel( "**********************************************");
    private JLabel question;
	private JTextField input;
	protected static Color c;


    public Content() {

		num1 = (int)Math.random()*12;
		num2 = (int)Math.random()*12;
		question = new JLabel("What is the product of " + num1 + " and " + num2 + "?");
		input = new JTextField("Get Return",10);

		titleLabel.setAlignmentX (Component.CENTER_ALIGNMENT);
 	    underTitle1.setAlignmentX (Component.CENTER_ALIGNMENT);
		underTitle2.setAlignmentX (Component.CENTER_ALIGNMENT);

    	input.addActionListener(new myActionListener());


    	//setting the panel
    	setPreferredSize (new Dimension (300, 100));
      	setBackground (Color.yellow);

      	add (Box.createRigidArea (new Dimension(0,5)));
      	add (titleLabel);
      	add (underTitle1);
      	add (question);
      	add (underTitle2);
      	add (Box.createHorizontalBox());
      	add (input);

    }

    private void changeScreen(String s)
    {
    	response = Integer.parseInt(s);
    	correct = (response == num1 * num2);

    	if (correct == true)
    	{
    		c = (Color.GREEN);
    	}
    	else
    	{
    		c = (Color.RED);
    	}

		// new question prompted
    	num1 = (int)Math.random()*12;
    	num2 = (int)Math.random()*12;
    	question = new JLabel("What is the product of " + num1 + " and " + num2 + "?");
    	question.updateUI();

    }

    public Color getColor()
    {
    	return c;
    }

public class myActionListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		changeScreen(s);
		input.setText(s);

	}
}
}

