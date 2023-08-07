package com.day06;

import java.util.Scanner;

public class Study03 {
//	출력메시지 저장
//		합격메세지
//			문자열 변수
//		불합격메시지
//			문자열 변수
//	키보드로 
//	점수를 입력 받고 
//		국어, 영어, 수학 세 과목 점수
//	합계와 평균을 계산
//		합계
//			합계저장
//		평균
//			평균저장
//	
//	합격/불합격 처리
//		합격이면
//			세 과목의 점수가 각각 40점 이상이면서 
//			평균이 60점 이상일 경우
//		불합격이면
	
	public static void main(String[] args) {
		int iNlScore = 0; int iEngScore = 0; int iMathScore = 0;
		int iSume = 0;
		int iAvg = 0;
		
		Scanner sc = new java.util.Scanner(System.in);
		iNlScore = sc.nextInt(); iMathScore = sc.nextInt(); iEngScore = sc.nextInt();
		iAvg = (iNlScore+iMathScore+iEngScore)/3;
		
		
		
		if(((iNlScore>=40)&&(iEngScore>=40)&&(iMathScore>=40)) && (iAvg>=60)) {
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격입니다");
		}
		
	}
}
