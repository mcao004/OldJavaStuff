/*
 *Marvin Cao
 *Period 3
 *5/22/2115*/
// Create a simple "menu" GUI for editing text and handling files

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;


public class TextEditor extends JFrame {
	// instance variables
	JPanel topPanel, editorPanel;
	JScrollPane scroller;
	JTextArea editor;

	// Menu objects
	JMenuBar menuBar;
	JMenu fileMenu, editMenu;
	JMenuItem fileMenuLoad, fileMenuSave, fileMenuExit;
	JMenuItem editMenuCut, editMenuCopy, editMenuPaste;


    public TextEditor()
    {
    	topPanel = new JPanel(new BorderLayout());
    	//topPanel.setLayout(new BorderLayout());
    	editorPanel = new JPanel(new BorderLayout());
    	//editorPanel.setLayout(new BorderLayout());

    	scroller = new JScrollPane();
    	editor = new JTextArea();
    	editor.setColumns(40);

    	// set up the frame
    	setTitle("Simple Text Editor With Menus");
    	getContentPane().add(topPanel, BorderLayout.CENTER);

    	addWindowListener(new java.awt.event.WindowAdapter()
    	{
    		public void windowClosing(WindowEvent e)
    		{
    			System.exit(0);
    		}
    	});

    	// assemble componenets
    	topPanel.add(editorPanel,BorderLayout.CENTER);
    	editorPanel.add(scroller,BorderLayout.CENTER);
    	scroller.getViewport().add(editor);

    	//assemble menu bar
    	menuBar = new JMenuBar();
    	setJMenuBar(menuBar);
    	addFileMenu(); // helper method
    	addEditMenu(); // helper method

    	// display frame
    	pack();
    	setSize(400,300);
    	setVisible(true);

    } // end constructor

    private void addFileMenu(){
    	fileMenu = new JMenu("File");
    	fileMenuLoad = new JMenuItem("Load...");
    	fileMenu.add(fileMenuLoad);
    	fileMenuLoad.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			loadFile();
    		}
    	});


	    fileMenuSave = new JMenuItem("Save...");
	    fileMenu.add(fileMenuSave);
	    fileMenuSave.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		saveFile();
	    	}
	    });

	    fileMenu.addSeparator();
	    fileMenuExit = new JMenuItem("Exit");
	    fileMenu.add(fileMenuExit);
	    fileMenuExit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e)
	    	{
    			System.exit(0);
    		}
	    });

	    	menuBar.add(fileMenu);   //add the file Menu to the menu bar object
    }

    // helper method to add the edit menu items and listeners
    private void addEditMenu(){
    	editMenu = new JMenu("Edit");
    	editMenuCut = new JMenuItem("Cut");
    	editMenu.add(editMenuCut);
    	editMenuCut.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			cut();
    		}
    	});
    	editMenuCopy = new JMenuItem("Copy");
    	editMenu.add(editMenuCopy);
    	editMenuCopy.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			copy();
    		}
    	});

    	editMenuPaste = new JMenuItem("Paste");
    	editMenu.add(editMenuPaste);
    	editMenuPaste.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e)
    		{
    			paste();
    		}
    	});

			menuBar.add(editMenu);
    }

    // file handling methods hellper methods
    private void loadFile()
    {
    	JFileChooser fc = new JFileChooser();
    	int returnVal = fc.showOpenDialog(this);
    	if (returnVal == JFileChooser.APPROVE_OPTION) // if file selected
    	{
    		File file = fc.getSelectedFile();
    		try{
    			editor.read(new FileReader(file),null);

    		}catch (IOException exp)
    		{
    			System.out.println("Couldn't open" + file.getName());
    		}
    	}
    }

    private void saveFile() // open a file save dialog
    {
    	JFileChooser fc = new JFileChooser();
    	int returnVal = fc.showSaveDialog(this);
    	if (returnVal == JFileChooser.APPROVE_OPTION)
    	{
    		File file = fc.getSelectedFile();
    		try{
    			editor.write(new FileWriter(file));
    		}catch(IOException exp)
    		{
    			System.out.println("Sorry, you mudafuka, couldn't write " + file.getName());
    		}
    	}
    }

    // hellper methods for the edit menu

    private void copy()
    {
    	editor.copy();
    	editor.requestFocus();
    }

    private void cut()
    {
    	editor.cut();
    	editor.requestFocus();
    }

    private void paste()
    {
    	editor.paste();
    	editor.requestFocus();
    }

    public static void main (String[] args)
    {
    	final TextEditor editor = new TextEditor();
    }
}