package com.swingpractice1;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingExample02 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SwingExample02() {
		JButton b = new JButton("누르기");
		b.setBounds(130, 100, 150, 60);
		add(b);
		
		setSize(800, 600);
		setLayout(null);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SwingExample02();
		
	}

}
