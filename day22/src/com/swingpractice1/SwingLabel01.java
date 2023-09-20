package com.swingpractice1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingLabel01 {
	
	JFrame f;
	JLabel lblFristName;
	JLabel lblMiddleName;
	JLabel lblLastName;
	JLabel lblAge;
	
	JTextField tfFristName;
	JTextField tfMiddleName;
	JTextField tfLastName;
	JTextField tfAge;
	
	JButton btnClick;
	
	
	
	public SwingLabel01() {
		f = new JFrame();
		
		lblFristName = new JLabel("First Name");
		lblFristName.setBounds(30,50,75,50);
		tfFristName = new JTextField();
		tfFristName.setBounds(120,50,250,50);
		
		lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setBounds(30,120,75,50);
		tfMiddleName = new JTextField();
		tfMiddleName.setBounds(120,120,250,50);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(30,190,75,50);
		tfLastName = new JTextField();
		tfLastName.setBounds(120,190,250,50);
		
		lblAge = new JLabel("Age");
		lblAge.setBounds(30,260,75,50);
		tfAge = new JTextField();
		tfAge.setBounds(120,260,250,50);
		
		btnClick = new JButton("Click");
		btnClick.setBounds(120,330,100,50);
		
		
		f.add(lblFristName);
		f.add(lblMiddleName);
		f.add(lblLastName);
		f.add(lblAge);
		
		f.add(tfFristName);
		f.add(tfMiddleName);
		f.add(tfLastName);
		f.add(tfAge);
		
		f.add(btnClick);
		
		
		f.setSize(800, 600);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SwingLabel01();
	}

}
