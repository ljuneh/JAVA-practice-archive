package study.day11;

import java.util.Arrays;
import java.util.Scanner;

public class Procedural {
	
	public static void main(String[] args) {
		int[] inventory = new int[4];
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<inventory.length; i++) {
			System.out.print((char)(65+i)+" 상품 재고 입력 : ");
			inventory[i] = sc.nextInt();
		}
		System.out.println("상품 재고 "+Arrays.toString(inventory));
		int[] proper = {5,5,5,5};
		
		sc.nextLine();
		System.out.println("다음으로 넘어가려면 엔터를 입력");
		sc.nextLine();
		
		for(int i=0; i<10; i++) {
			System.out.println((i+1)+"번째");
			discountInventory(inventory);
			System.out.println("현재 상품 재고 "+Arrays.toString(inventory));
			
			returnToProperInventory(inventory, proper);
			System.out.println("적정 수량을 채운 현재 상품 재고 "+Arrays.toString(inventory));
			
			System.out.println("다음으로 넘어가려면 엔터를 입력");
			sc.nextLine();
		}
		
		
		sc.close();
		System.out.println("프로그램 종료");
	}
	
	public static void discountInventory(int[] inventory) {
		for(int j=0; j<inventory.length; j++) {
			int productCount = inventory[j];
			int discount = (int) (Math.random()*(productCount+1));
			System.out.println((char)(65+j)+" 상품을 "+discount+"만큼 차감");
			inventory[j] -= discount; 	
		}
	}
	
	public static void returnToProperInventory(int[] inventory, int[] proper) {
		if(inventory.length == proper.length) {
			for(int j=0; j<inventory.length; j++) {
				if(inventory[j]<proper[j]) {
					System.out.println((char)(65+j)+" 상품이 적정 수량보다 적어 새로 채움");
					inventory[j]=proper[j];
				}
			}
		} else {
			return;
		}
	}
}
