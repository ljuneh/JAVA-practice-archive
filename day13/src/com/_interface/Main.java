package com._interface;

public class Main {
	public static void main(String[] args) {
		DatabaseModule db = new OracleDatabaseModule();
		
		int iRet = db.insert("test");
		System.out.println(iRet);
		
		String sRet = db.select();
		System.out.println(sRet);
		
		
		System.out.println(DatabaseModule.add(10,20));
	}
}
