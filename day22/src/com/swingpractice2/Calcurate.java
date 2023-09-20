package com.swingpractice2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Calcurate {
	private JFrame mainFrame;
	private JTextField tf;
	private JTextArea ta;
	private JButton[] numberPadArr;
	private JPanel controlPanel;
	
	private JButton btnCal;
	private JButton btnPlus;
	private JButton btnMul;
	private JButton btnMinus;
	private JButton btnDiv;
	private JButton btnEqual;
	
	public Calcurate() {
		
		mainFrame = new JFrame("Calcurator");
 		mainFrame.setSize(400,600);
 		mainFrame.setLayout(null);

 		mainFrame.addWindowListener(new WindowAdapter() {
 			public void windowClosing(WindowEvent windowEvent){
 				System.exit(0);
 			}
 		});
 		
 		ta = new JTextArea();
 		ta.setBounds(15, 30, 350, 50);
 		ta.setSize(350, 50);
 		Border tfLine = BorderFactory.createLineBorder(Color.black);
 		ta.setBorder(tfLine);
 		
 		controlPanel = new JPanel();
 		GridLayout grid = new GridLayout(4,4);
 		grid.setHgap(10);
 		grid.setVgap(10);
 		controlPanel.setLayout(grid);
 		controlPanel.setBounds(15,150,350,350);
 		
 		
		numberPadArr = new JButton[10];
		for(int i = 0; i<numberPadArr.length; i++) {
			numberPadArr[i] = new JButton();
			numberPadArr[i].setText(Integer.toString(i));
			numberPadArr[i].setBackground(Color.darkGray);
			numberPadArr[i].setForeground(Color.white);
			numberPadArr[i].setSize(50, 50);
		}
		
		btnCal = new JButton();
		btnCal.setText("C");
		btnCal.setBackground(Color.red);
		btnCal.setForeground(Color.white);
		btnCal.setSize(50, 50);
		
		btnPlus = new JButton();
		btnPlus.setText("+");
		btnPlus.setBackground(Color.gray);
		btnPlus.setForeground(Color.white);
		btnPlus.setSize(50, 50);
		
		btnMul = new JButton();
		btnMul.setText("X");
		btnMul.setBackground(Color.gray);
		btnMul.setForeground(Color.white);
		btnMul.setSize(50, 50);
		
		btnMinus = new JButton();
		btnMinus.setText("-");
		btnMinus.setBackground(Color.gray);
		btnMinus.setForeground(Color.white);
		btnMinus.setSize(50, 50);
		
		btnDiv = new JButton();
		btnDiv.setText("/");
		btnDiv.setBackground(Color.gray);
		btnDiv.setForeground(Color.white);
		btnDiv.setSize(50, 50);
		
		btnEqual = new JButton();
		btnEqual.setText("=");
		btnEqual.setBackground(Color.gray);
		btnEqual.setForeground(Color.white);
		btnEqual.setSize(50, 50);
		
		ArrayList<JButton> calList = new ArrayList<>();
		calList.add(btnCal);
		calList.add(btnPlus);
		calList.add(btnMul);
		calList.add(btnMinus);
		calList.add(btnDiv);
		calList.add(btnEqual);
		
		
		controlPanel.add(btnCal);
		controlPanel.add(btnDiv);
		controlPanel.add(btnMul);
		controlPanel.add(btnEqual);
		controlPanel.add(numberPadArr[7]);
		controlPanel.add(numberPadArr[8]);
		controlPanel.add(numberPadArr[9]);
		controlPanel.add(btnPlus);
		controlPanel.add(numberPadArr[4]);
		controlPanel.add(numberPadArr[5]);
		controlPanel.add(numberPadArr[6]);
		controlPanel.add(btnMinus);
		controlPanel.add(numberPadArr[1]);
		controlPanel.add(numberPadArr[2]);
		controlPanel.add(numberPadArr[3]);
		controlPanel.add(numberPadArr[0]);
		
		for(int i = 0; i<numberPadArr.length; i++) {
			numberPadArr[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String sNumber = e.getActionCommand();
					ta.append(sNumber);
				}
			});
		}
		
		for(JButton btn: calList) {
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String sOperator = e.getActionCommand();
					ta.append(sOperator);
				}
			});
		}
		
		
		mainFrame.add(ta);
		mainFrame.add(controlPanel);
		
		
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Calcurate calcurate = new Calcurate();
	}
	
	
	
	

}
