package com.arcon;

import java.util.Scanner;

public class variablePractice4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("문자열을 입력하세요");
//		String str = sc.nextLine();
//		for(int i=0; i<3; i++) {
//			System.out.print((i+1)+"번째 문자 : " + str.substring(i, i+1));
//			System.out.println();
//		}
		System.out.println("인원 수 : ");
		int peoplenumber = sc.nextInt();
		System.out.println("사탕개수 : ");
		int itemnumber = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + itemnumber/peoplenumber);
		System.out.println("남는 사탕 개수 : " + itemnumber%peoplenumber);
		
		sc.close();
	}
}
