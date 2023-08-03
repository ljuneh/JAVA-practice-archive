package com.arcon;

public class Study01 {
	public static void main(String[] args) {
		// 일반 변수 선언(초기화)
		byte bNumber = 0; System.out.println(bNumber); // -128~127
		short sNumber = 0; System.out.println(sNumber);
		int iNumber = 0; System.out.println(iNumber);
//		sNumber = iNumber; error
		
		long lNumber = 0L; System.out.println(lNumber);
		float fNumber = 0.0F; System.out.println(fNumber);
		char cChar = 'c'; System.out.println(cChar);
		String str = "str"; System.out.println(str);
		
		// 특수 변수
		byte[] bNumberArr = {1, 2, 3, 4, 5};
		System.out.println(bNumberArr.length);
		
		// 조건문
		int[] intArr = {1,2,3,4,5,6,7,8,9,10};
//		int index = 0;
//		System.out.println((index+1) + "번째 변수 : " + intArr[index]);
//		if(intArr[index]%2 == 0) {
//			System.out.println((index+1) + "번째 변수는 짝수");
//		} else {
//			System.out.println((index+1) + "번째 변수는 홀수");
//		}
//		index ++;
		// 이걸 10번 반복해야됨
		
		
		// 반복문
		for (int i = 1; i<= 10; i ++) {
			System.out.print(i+"   ");
		}
		System.out.println("\n출력종료");
		
		for(int i = 2; i<=9; i ++) {
			System.out.print(i+" : ");
			for (int j = 1; j<=9; j ++) {
				System.out.print(i+"X"+j+"="+(i*j)+" ");
			}
			System.out.print("\n");
		}
		System.out.println("\n출력종료");
		
		//////////////
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <=i; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <=i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
		///////////////////////////
		// 함수
		int index = 0;
		printVerifyNumber(index);
		index++;
		printVerifyNumber(index);
		index++;
		printVerifyNumber(index);
		index++;
		printVerifyNumber(index);
		index++;
		printVerifyNumber(index);
		index++;
		printVerifyNumber(index);
		index++;
		printVerifyNumber(index);
		index++;
		printVerifyNumber(index);
		index++;
		printVerifyNumber(index);
		index++;
		printVerifyNumber(index);
		index++;
		/////////////////////////
		// while
		
		int[] iEvvenOddCountArr = {0,0};
		int iWhileValue =1;
		while(iWhileValue<=30) {
			if(iWhileValue%2==0) {
				iEvvenOddCountArr[0]++;
			} else {
				iEvvenOddCountArr[1]++;
			}
			iWhileValue++;
		}
		System.out.println(iEvvenOddCountArr[0] +", "+ iEvvenOddCountArr[1]);
		
		
		
		
		
	}	
	
////////////////////////
	public static void printVerifyNumber(int iIndex) {
		int[] iNumberArr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println((iIndex+1) + "번째 변수 : " + iNumberArr[iIndex]);
		if(iNumberArr[iIndex]%1 == 0) {
			System.out.println((iIndex+1) + "번째 변수는 1의 배수");
		}
		if(iNumberArr[iIndex]%2 == 0) {
			System.out.println((iIndex+1) + "번째 변수는 짝수");
			if(iNumberArr[iIndex]%4 == 0) {
				System.out.println((iIndex+1) + "번째 변수는 4의 배수");
			}
			if(iNumberArr[iIndex]%6 == 0) {
				System.out.println((iIndex+1) + "번째 변수는 6의 배수");
			}
			if(iNumberArr[iIndex]%8 == 0) {
				System.out.println((iIndex+1) + "번째 변수는 8의 배수");
			}
			if(iNumberArr[iIndex]%10 == 0) {
				System.out.println((iIndex+1) + "번째 변수는 10의 배수");
			}
		} else {
			System.out.println((iIndex+1) + "번째 변수는 홀수");
		}
		if(iNumberArr[iIndex]%3 == 0) {
			System.out.println((iIndex+1) + "번째 변수는 3의 배수");
		}
		if(iNumberArr[iIndex]%5 == 0) {
			System.out.println((iIndex+1) + "번째 변수는 5의 배수");
		}
		if(iNumberArr[iIndex]%7 == 0) {
			System.out.println((iIndex+1) + "번째 변수는 7의 배수");
		}
		if(iNumberArr[iIndex]%9 == 0) {
			System.out.println((iIndex+1) + "번째 변수는 9의 배수");
		}
	}
}
