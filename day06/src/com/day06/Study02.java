package com.day06;

import java.util.Scanner;

public class Study02 {
	
	public static void main(String[] args) {
//		1. 키보드 : Scanner 객체 생성
//		2. 입력 받은 
//			2.1 정수
//		3. 입력한 수 체크
//		양수이면서 
//			짝수일 때만 
//				“짝수다”를 출력하고
//			짝수가 아니면 
//				“홀수다“를 출력하세요.
//		양수가 아니면 
//			“양수만 입력해주세요.”를 출력하세요.
		Scanner sc = new java.util.Scanner(System.in);
		int iInputValue = 0;
		
		iInputValue = sc.nextInt();
		
		if(iInputValue <= 0) {
			System.out.println("양수만 입력");
		} else {
			if(iInputValue%2 == 0) {
				System.out.println("짝수다");
			} else {
				System.out.println("홀수다");
			}
		}
		
		sc.close();
		
	}
}
