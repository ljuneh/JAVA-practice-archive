package com.swingpractice1;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingExample01 {
	
	JFrame f;
	
	public SwingExample01() {
		this.f = new JFrame();
		JButton b = new JButton("누르기");
		b.setBounds(130, 100, 150, 60);
		f.add(b);
		
		f.setSize(800, 600);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SwingExample01();
	}

}
