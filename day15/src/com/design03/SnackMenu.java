package com.design03;


import java.util.Scanner;

public class SnackMenu {
	private SnackController snackController;
	
	public Snack menu(Scanner sc) {
		snackController = new SnackController();
		
		System.out.println("==============================");
		System.out.print("");
		System.out.print("���� : ");
		String kind = sc.nextLine();
		
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		
		System.out.print("�� : ");
		String flavor = sc.nextLine();
		
		System.out.print("���� : ");
		int nameOf = Integer.parseInt(sc.nextLine());
		
		System.out.print("���� : ");
		int price = Integer.parseInt(sc.nextLine());
		
		Snack snack = snackController.savaData(kind, name, flavor, nameOf, price);
		System.out.println("snack ������ ���� �Ϸ�");
		
		
		String confirmMsg = snackController.confirmData(sc);
		if(confirmMsg != "") {
			System.out.println(confirmMsg);
		}
		
		
		System.out.println("==============================");
		return snack;
	}
}
