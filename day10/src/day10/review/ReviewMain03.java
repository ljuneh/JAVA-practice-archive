package day10.review;

import java.util.Scanner;

public class ReviewMain03 {
	public static void main(String[] args) {
		
		int pivot = 5;
		Scanner sc = new Scanner(System.in);
		comparsion(sc, "int", pivot);
		comparsion(sc, "int", pivot);
		comparsion(sc, "float", pivot);
		comparsion(sc, "double", pivot);

		sc.close();
		
		
	
		
	}	
	public static <T> void comparsion(Scanner sc, String key, int pivot) {
		
		if(key == "int") {
			System.out.println("������ �Է�");
			int iNumber = sc.nextInt();
			if(iNumber<pivot) {
				System.out.println(iNumber+"�� "+pivot+"���� �۴�");
			}
		} else if (key == "float") {
			System.out.println("�Ǽ��� �Է�");
			float fNumber = sc.nextFloat();
			if(fNumber<pivot) {
				System.out.println(fNumber+"�� "+pivot+"���� �۴�");
			}
		} else if (key == "double") {
			System.out.println("�Ǽ��� �Է�");
			double dNumber = sc.nextDouble();
			if(dNumber<pivot) {
				System.out.println(dNumber+"�� "+pivot+"���� �۴�");
			}
		}
		
	}
}
