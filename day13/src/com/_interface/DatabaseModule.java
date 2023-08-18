package com._interface;

public interface DatabaseModule {
	int DB_VERSION = 1;
	
	int insert(String s);
	String select();
	
	public static int add(int a, int b) {
		int iRet = subAdd(a, b);
		return iRet;
	}
	
	default int add(int a, int b, int c) {
		int iRet = a+b+c;
		return iRet;
	}
	
	// JDK 9
	private static int subAdd(int a, int b) {
		int iRet = a+b;
		return iRet;
	}
}
