package com.swingpractice1;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class SwingList01 {
	JFrame f;
	JList<String> lList;
	
	public SwingList01() {
		f = new JFrame("List example");
		
		DefaultListModel<String> dlm = new DefaultListModel<>();
		dlm.addElement("item1");
		dlm.addElement("item2");
		dlm.addElement("item3");
		dlm.addElement("item4");
		dlm.addElement("item5");
		
		lList = new JList<>(dlm);
		
		lList.setBounds(100, 30, 100, 100);
		
		f.add(lList);
		f.setLocation(500, 300);
		f.setSize(300, 500);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SwingList01();
	}

}
