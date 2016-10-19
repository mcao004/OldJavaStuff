/**
 Marvin Cao
 5/15/15
 Period 3
 */
 import java.awt.*;
 import java.util.*;
 import java.awt.event.*;
 import javax.swing.*;


public class MultiplicationTest extends JFrame {

	JFrame frame;
	public MultiplicationTest()
   {
      frame = new JFrame ("You suck at math, so I'm testing you on multiplication!!!");
      frame.setLayout(new GridLayout());
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.setBackground(Content.c);



      frame.getContentPane().add(new Content());



 //     frame.getContentPane().add(controlPanel);
      frame.pack();
      frame.show();
   }


}