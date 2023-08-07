package com.day06;

import java.util.Scanner;

public class Study05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("마지막 숫자를 입력");
		int iInputValue = sc.nextInt();
		if(iInputValue>=1 ) {
			for(int i=1; i<iInputValue;i++) {
				if(i==(iInputValue-1)) System.out.println((i+1));
				else System.out.println((i+1)+" ");
			}
		} else {
			System.out.println("1 이상의 숫자 입력하세요");
		}
	}
}
