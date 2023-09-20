package com.swingpractice2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JLabelDemo {
	private JFrame mainFrame;
 	private JLabel headerLabel;
 	private JLabel statusLabel;
 	private JPanel controlPanel;
 	
 	public static void main(String[] args){
 		JLabelDemo label = new JLabelDemo();
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
 		JLabel label = new JLabel("", JLabel.CENTER);
 		label.setText("Welcome to Swing Label");
 		label.setOpaque(true);
 		label.setBackground(Color.GRAY);
 		label.setForeground(Color.WHITE);
 		controlPanel.add(label);
 		mainFrame.setVisible(true);
 	}
}

