package com.swingpractice2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JBUttonDemo {
	private JFrame mainFrame;
 	private JLabel headerLabel;
 	private JLabel statusLabel;
 	private JPanel controlPanel;
 	private JButton btnOk;
 	private JButton btnCancel;
 	
 	
 	public static void main(String[] args){
 		JBUttonDemo label = new JBUttonDemo();
 		label. showLabel ();
 	}
 	
 	
 	private void showLabel (){
 		mainFrame = new JFrame("Java Swing Label Control");
 		mainFrame.setSize(400,400);
 		mainFrame.setLayout(new GridLayout(3, 1));

 		mainFrame.addWindowListener(new WindowAdapter() {
 			public void windowClosing(WindowEvent windowEvent){
 				System.exit(0);
 			}
 		});
 		headerLabel = new JLabel("", JLabel.CENTER);
 		statusLabel = new JLabel("",JLabel.CENTER);
 		statusLabel.setSize(350,100);
 		controlPanel = new JPanel();
 		controlPanel.setLayout(new FlowLayout());
 		mainFrame.add(headerLabel);
 		mainFrame.add(controlPanel);
 		mainFrame.add(statusLabel);
 		
 		
 		headerLabel.setText("Control in action: JLabel");
 		statusLabel.setText("Good luck");
 		
 		btnOk = new JButton("ok");
 		
 		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				statusLabel.setText("click ok");
			}
		});
 		
 		btnCancel = new JButton("cancel");
 		
 		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				statusLabel.setText("click cancel");
			}
		});
 		
 		
 		
 		
 		
 		controlPanel.add(btnOk);
 		controlPanel.add(btnCancel);
 		
 		mainFrame.setVisible(true);
 	}
}

