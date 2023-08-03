package com.arcon;

import java.util.HashSet;

public class Study02 {
	public static void main(String[] args) {
		practice11("1234");
	}
	
	public static void practice11(String str) {
		char[] charArray = new char[str.length()];
		HashSet<Character> charHashSet = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			charArray[i] = str.charAt(i);
			charHashSet.add(str.charAt(i));
			System.out.println(charArray[i]);
		}
		boolean condition1, condition2, condition3;
		if(str.length() != 4) {
			System.out.println("자리 수 안 맞음");
			condition1 = false;
		} else condition1 = true;
		if(1<=(charArray[0]-48) && (charArray[0]-48)<=9) condition2 = true;
		else {
			System.out.println("앞자리 수의 값이 1~9사이의 정수가 아님");
			condition2 = false;
		}
		if(charHashSet.size()==charArray.length) condition3 = true;
		else {
			System.out.println("중복 수 감지");
			condition3 = false;
		}
		
		if(condition1&&condition2&&condition3) System.out.println("비밀번호 등록");
		
		
		
	}
	
}
