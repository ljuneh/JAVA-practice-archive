package com.swingpractice1;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SwingMenu {
	JFrame f;
	JMenuBar mbTextEdit;
	JMenu muFile, muPrint;
	JMenuItem miCommand1, miCommand2, miCommand3, miCommand4, miCommand5, miCommand6;
	
	public SwingMenu() {
		f = new JFrame("menu example");
		
		mbTextEdit = new JMenuBar();
		muFile = new JMenu("Menu");
		muPrint = new JMenu("Sub Menu");
		
		miCommand1 = new JMenuItem("item 1");
		miCommand2 = new JMenuItem("item 2");
		miCommand3 = new JMenuItem("item 3");
		miCommand4 = new JMenuItem("item 4");
		miCommand5 = new JMenuItem("item 5");
		miCommand6 = new JMenuItem("item 6");
		
		mbTextEdit.add(muFile);
		
		muFile.add(miCommand1);
		muFile.add(miCommand2);
		muFile.add(miCommand3);
		muFile.add(muPrint);
		
		muPrint.add(miCommand4);
		muPrint.add(miCommand5);
		muPrint.add(miCommand6);
		
		
		f.setJMenuBar(mbTextEdit);
		
		f.setSize(500, 300);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SwingMenu();
	}

}
