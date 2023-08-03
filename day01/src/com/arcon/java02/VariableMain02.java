package com.arcon.java02;

public class VariableMain02 {
	public static void main(String[] args) {
		// 강제(명시적) 전환
		// 데이터타입
		//int testData = 200;
		//short testData2;
		//testData2 = (short)testData;
		byte byteNumber = 0;
		short shortNumber = 128;
		
		byteNumber = (byte)shortNumber;
		
		System.out.println(byteNumber);
	}
	
}
