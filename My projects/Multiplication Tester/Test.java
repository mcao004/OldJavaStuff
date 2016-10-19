/**
 * @(#)Test.java
 *
 *
 * @author
 * @version 1.00 2015/5/18
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test extends JPanel {
  JTextField text = new JTextField("Press Return", 10);

  public Test() {
    text.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Text=" + text.getText()); // to be edited later
      }

    });


  }


}