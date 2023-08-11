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
			System.out.println("정수를 입력");
			int iNumber = sc.nextInt();
			if(iNumber<pivot) {
				System.out.println(iNumber+"는 "+pivot+"보다 작다");
			}
		} else if (key == "float") {
			System.out.println("실수를 입력");
			float fNumber = sc.nextFloat();
			if(fNumber<pivot) {
				System.out.println(fNumber+"는 "+pivot+"보다 작다");
			}
		} else if (key == "double") {
			System.out.println("실수를 입력");
			double dNumber = sc.nextDouble();
			if(dNumber<pivot) {
				System.out.println(dNumber+"는 "+pivot+"보다 작다");
			}
		}
		
	}
}
