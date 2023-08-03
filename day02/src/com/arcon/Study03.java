package com.arcon;

import java.util.Scanner;

public class Study03 {
	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("계산기 프로그램");
			int selectMenu = sc.nextInt();
			if(selectMenu == 1) {
				plusMenu(sc);
			} else if (selectMenu == 2) {
				minusMenu(sc);
			} else if (selectMenu == 3) {
				multiplyMenu(sc);
			} else if (selectMenu == 4) {
				divideMenu(sc);
			} else if(selectMenu == 99) {
				System.out.println("프로그램 종료");
				sc.close();
				break;
			} else {
				System.out.println("잘못된 숫자 입력 다시 메뉴 실행");
			}
		}
	} // main 종료 
	
	public static void plusMenu(Scanner sc) {
		System.out.println("더하기");
		System.out.println("첫번째 숫자");
		int number1 = sc.nextInt();
		System.out.println("두번째 숫자");
		int number2 = sc.nextInt();
		int result = plus(number1, number2);
		System.out.println(number1 + "+" + number2 + "=" + result);
		
	}
	public static int plus(int num1, int num2) {
		return num1 + num2;
	}
	////////// plus end
	
	public static void minusMenu(Scanner sc) {
		System.out.println("빼기");
		System.out.println("첫번째 숫자");
		int number1 = sc.nextInt();
		System.out.println("두번째 숫자");
		int number2 = sc.nextInt();
		int result = minus(number1, number2);
		System.out.println(number1 + "-" + number2 + "=" + result);
		
	}
	public static int minus(int num1, int num2) {
		return num1 - num2;
	}
	////////// minus end
	
	public static void multiplyMenu(Scanner sc) {
		System.out.println("곱하기");
		System.out.println("첫번째 숫자");
		int number1 = sc.nextInt();
		System.out.println("두번째 숫자");
		int number2 = sc.nextInt();
		int result = multiply(number1, number2);
		System.out.println(number1 + "*" + number2 + "=" + result);
		
	}
	public static int multiply(int num1, int num2) {
		return num1 * num2;
	}
	////////// multiply end
	
	public static void divideMenu(Scanner sc) {
		System.out.println("나누기");
		System.out.println("나누어지는 수");
		int number1 = sc.nextInt();
		System.out.println("나누는 수");
		int number2 = sc.nextInt();
		int result = 0;
		if(number2 == 0) {
			System.out.println("나누는 수는 0이 될 수 없습니다. 다시 입력하세요");
			divideMenu(sc);
		} else {
			result = divide(number1, number2);
		}
		System.out.println(number1 + "/" + number2 + "=" + result);
		
	}
	public static int divide(int num1, int num2) {
		return num1 / num2;
	}
	//////////
	
	
}
