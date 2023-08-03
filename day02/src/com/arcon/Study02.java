package com.arcon;
import java.util.Scanner;

public class Study02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수:>>>");
		int nlpoint = sc.nextInt();
		System.out.println("수학점수:>>>");
		int mathpoint = sc.nextInt();
		System.out.println("영어점수:>>>");
		int elpoint = sc.nextInt();
		
		System.out.println("전체 점수의 합: "+(nlpoint+elpoint+mathpoint));
		
		sc.close();
//		if(nlpoint<10) {
//			System.out.println("불합격");
//		} else if (mathpoint<10){
//			System.out.println("불합격");
//		} else if (elpoint<10){
//			System.out.println("불합격");
//		}
		boolean singlepass = singlePass(nlpoint, mathpoint, elpoint);
		boolean avgpass = avgPass(nlpoint, mathpoint, elpoint);
		if(singlepass && avgpass) {
			System.out.println("합격");
		} else System.out.println("불합격");
		
	}
	public static boolean singlePass(int point1, int point2, int point3) {
		if(point1<10 || point2<10 || point3<10) {
			System.out.println("과락점수 미달");
			return false;
		} else {
			return true;
		}
	}
	public static boolean avgPass(int point1, int point2, int point3) {
		float avgpoint = (point1+point2+point3)/3;
		System.out.println("전체 점수의 평균: "+(avgpoint));
		if(avgpoint<10) {
			System.out.println("평균점수 미달");
			return false;
		} else return true;
	}
}
