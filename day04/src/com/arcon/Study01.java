package com.arcon;

public class Study01 {
	public static void main(String[] args) {
		Study01 study = new Study01();
		study.practice9(100, 100, 100, 20);
	}
	
	public boolean practice9(int sc1, int sc2, int sc3, int cnt) {
		boolean isabsent;
		double absentSc = ((double) cnt/20);
		if(absentSc < 0.7) {
			isabsent = false;
		} else {
			isabsent = true;
		}
		double sc = (sc1*0.2 + sc2*0.3 + sc3*0.3 + absentSc*20);
		System.out.println(sc);
		if(isabsent && sc >= 70) {
			System.out.println("pass");
			return true;
		} else {
			System.out.println("fail");
			return false;
		}
	}
}
