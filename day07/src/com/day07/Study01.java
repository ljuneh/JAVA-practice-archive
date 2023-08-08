package com.day07;

import java.util.Scanner;

public class Study01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sInputMsg = "";
		char[] cArray;
		int iArraySize = 0;
		System.out.println("문자열을 입력 ");
		sInputMsg = sc.nextLine();
		iArraySize = sInputMsg.length();
		cArray = new char[iArraySize];
		char cChar = 'p';
		int iCount = 0;
		for(int i=0; i<iArraySize;i++) {
			cArray[i] = sInputMsg.charAt(i);
		}
		for(int i=0; i<iArraySize;i++) {
			System.out.println(cArray[i]+"#");
		}
		for(int i=0; i<iArraySize;i++) {
			if(cArray[i]==cChar) {
				iCount++;
			}
		}
		System.out.println("일치하는 문자개수 : "+iCount);
	}
}
