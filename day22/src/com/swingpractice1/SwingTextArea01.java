package com.swingpractice1;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SwingTextArea01 {
	
	JFrame f;
	JTextArea taValue;
	
	public SwingTextArea01() {
		f = new JFrame("Text Form Example");
		
		taValue = new JTextArea("Text Area");
		taValue.setBounds(10, 20, 300, 450);
		
		f.add(taValue);
		
		f.setSize(500, 300);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingTextArea01();
	}

}
