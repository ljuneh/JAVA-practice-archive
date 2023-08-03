package com.arcon;

import java.util.Scanner;

public class VariablePractice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("성별을 입력하세요(남/여) : ");
		String gender = sc.nextLine();
		System.out.print("나이를 입력하세요 : ");
		String old = sc.nextLine();
		System.out.print("키를 입력하세요(cm) : ");
		String tall = sc.nextLine();
		
		String context = String.format("키 %s인 %s살 %s %s님 반갑습니다", tall, old, gender, name);
		System.out.println(context);
		sc.close();
		
	}
}
