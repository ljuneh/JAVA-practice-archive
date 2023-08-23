package com.design03;


import java.util.Scanner;

public class SnackMenu {
	private SnackController snackController;
	
	public Snack menu(Scanner sc) {
		snackController = new SnackController();
		
		System.out.println("==============================");
		System.out.print("");
		System.out.print("종류 : ");
		String kind = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
		
		System.out.print("개수 : ");
		int nameOf = Integer.parseInt(sc.nextLine());
		
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		Snack snack = snackController.savaData(kind, name, flavor, nameOf, price);
		System.out.println("snack 데이터 저장 완료");
		
		
		String confirmMsg = snackController.confirmData(sc);
		if(confirmMsg != "") {
			System.out.println(confirmMsg);
		}
		
		
		System.out.println("==============================");
		return snack;
	}
}
