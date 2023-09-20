package com.swingpractice1;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class SwingComboBox {
	JFrame f;
	JComboBox<String> cbNmae;
	
	public SwingComboBox() {
		f = new JFrame("comboBox example");
		String[] name = {"name1", "name2", "name3"};
		cbNmae = new JComboBox<String>(name);
		cbNmae.setBounds(30, 20, 100, 50);
		
		f.add(cbNmae);
		
		f.setSize(500, 150);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingComboBox();
	}

}
