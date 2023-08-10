package study.maintoclass;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 필드 영역
		// 개체 부분
		Scanner sc = new Scanner(System.in);
		
		// 공통 부분
		double number1; double number2;
		
		// 결과 저장 부분
		
		// 더하기 부분
		double plusResult;
		// 빼기 부분
		double minusResult;
		// 곱하기 부분
		double multiplyResult;
		// 나누기 부분
		double divideResult;
		
		// 오퍼레이션 부분
		System.out.print("첫번째 숫자 입력 : ");
		number1 = sc.nextDouble();
		System.out.print("두번째 숫자 입력 : ");
		number2 = sc.nextDouble();
		
		sc.close();
		
		// 더하기 부분
//		plusResult = number1 + number2;
//		System.out.println(plusResult);
//		// 빼기 부분
//		minusResult = number1 - number2;
//		System.out.println(minusResult);
//		// 곱하기 부분
//		multiplyResult = number1 * number2;
//		System.out.println(multiplyResult);
//		// 나누기 부분
//		if(number2==0) {
//			System.out.println("숫자를 0으로 나누지 마세요");
//		} else {
//			divideResult = number1 / number2;
//			System.out.println(divideResult);
//		}
		Operation operation = new Operation();
		operation.addOperation(number1, number2);
		operation.minusOperation(number1, number2);
		operation.multiplyOperation(number1, number2);
		operation.divideOperation(number1, number2);
	}
	
	public static double addOperation(double number1, double number2) {
		double plusResult;
		plusResult = number1 + number2;
		System.out.println(plusResult);
		return plusResult;
	}
	public static double minusOperation(double number1, double number2) {
		double minusResult;
		minusResult = number1 - number2;
		System.out.println(minusResult);
		return minusResult;
	}
	public static double multiplyOperation(double number1, double number2) {
		double multiplyResult;
		multiplyResult = number1 * number2;
		System.out.println(multiplyResult);
		return multiplyResult;
	}
	public static double divideOperation(double number1, double number2) {
		double divideResult = 100000;
		if(number2==0) {
			System.out.println("숫자를 0으로 나누지 마세요");
		} else {
			divideResult = number1 / number2;
			System.out.println(divideResult);
		}
		return divideResult;
	}
		
}
