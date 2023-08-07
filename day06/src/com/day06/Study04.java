package com.day06;

import java.util.Scanner;

public class Study04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iMonth = sc.nextInt();
		switch (iMonth) {
		case 3:
			
		case 4:
		
		case 5:
			System.out.println("봄");
			break;
			
		case 6:
			
		case 7:
			
		case 8:
			
		case 9:
			System.out.println("여름");
			break;
			
		case 10:
			
		case 11:
			System.out.println("가을");
			break;
			
		case 12:
			
		case 1:
			
		case 2:
			System.out.println("겨울");
			break;

		default:
			System.out.println("잘못 입력된 달입니다");
			break;
		}
	}
}
