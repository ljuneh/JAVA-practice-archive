package study.day11;

import java.util.Arrays;
import java.util.Scanner;

public class Procedural {
	
	public static void main(String[] args) {
		int[] inventory = new int[4];
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<inventory.length; i++) {
			System.out.print((char)(65+i)+" ��ǰ ��� �Է� : ");
			inventory[i] = sc.nextInt();
		}
		System.out.println("��ǰ ��� "+Arrays.toString(inventory));
		int[] proper = {5,5,5,5};
		
		sc.nextLine();
		System.out.println("�������� �Ѿ���� ���͸� �Է�");
		sc.nextLine();
		
		for(int i=0; i<10; i++) {
			System.out.println((i+1)+"��°");
			discountInventory(inventory);
			System.out.println("���� ��ǰ ��� "+Arrays.toString(inventory));
			
			returnToProperInventory(inventory, proper);
			System.out.println("���� ������ ä�� ���� ��ǰ ��� "+Arrays.toString(inventory));
			
			System.out.println("�������� �Ѿ���� ���͸� �Է�");
			sc.nextLine();
		}
		
		
		sc.close();
		System.out.println("���α׷� ����");
	}
	
	public static void discountInventory(int[] inventory) {
		for(int j=0; j<inventory.length; j++) {
			int productCount = inventory[j];
			int discount = (int) (Math.random()*(productCount+1));
			System.out.println((char)(65+j)+" ��ǰ�� "+discount+"��ŭ ����");
			inventory[j] -= discount; 	
		}
	}
	
	public static void returnToProperInventory(int[] inventory, int[] proper) {
		if(inventory.length == proper.length) {
			for(int j=0; j<inventory.length; j++) {
				if(inventory[j]<proper[j]) {
					System.out.println((char)(65+j)+" ��ǰ�� ���� �������� ���� ���� ä��");
					inventory[j]=proper[j];
				}
			}
		} else {
			return;
		}
	}
}
