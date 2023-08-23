package com.design03;

import java.util.Scanner;

public class SnackController {
	private Snack snack;
	
	public SnackController( ) {}
	
	public Snack savaData(String kind, String name, String flavor, int numOf, int price) {
		snack = new Snack();
		snack.setKind(kind);
		snack.setName(name);
		snack.setFlavor(flavor);
		snack.setNumOf(numOf);
		snack.setPrice(price);
		return snack;
	}
	
	public String confirmData(Scanner sc) {
		String confirmMsg = "";
//		sc.nextLine();
		System.out.print("����� �����͸� ����Ͻðڽ��ϱ�? (y/n) : ");
		char isConfirm = sc.nextLine().charAt(0);
		if(isConfirm == 'y') {
			confirmMsg = snack.infomation();
		}
		
		return confirmMsg;
	}
}
