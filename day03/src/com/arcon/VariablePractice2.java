package com.arcon;

import java.util.Scanner;

public class VariablePractice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 변수 : ");
		int number1 = sc.nextInt();
		System.out.println();
		System.out.print("두번째 변수 : ");
		int number2 = sc.nextInt();
		System.out.println();
		
		if(number2 == 0) {
			System.out.println("다시 입력하세요");
			number2 = sc.nextInt();
		}
		float divide = (float) number1/number2;
		System.out.println((number1+number2));
		System.out.println((number1-number2));
		System.out.println((number1*number2));
		System.out.println(divide);
		sc.close();
	}
}
