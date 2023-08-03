package com.arcon;

import java.util.Scanner;

public class Study03 {
	public static void main(String[] args) {
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		Scanner sc = new Scanner(System.in);
		int num= sc.nextInt();
		String[] week = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		if( num > 6 || num < 0) {
			System.out.println("숫자 범위 벗어남");
		} else {
			System.out.println(week[num]);
		}
		
		
		
		sc.close();
	}
}
