package com.design03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SnackMenu snackMenu = new SnackMenu();
//		Snack snack = snackMenu.menu();
		List<Snack> snackList = new ArrayList<Snack>();
		
		for(int i=0; i<2; i++) {
			
			snackList.add(snackMenu.menu(sc));
		}
		snackList.size();
		
		sc.close();
		
	}
}
