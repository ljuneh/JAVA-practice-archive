package study.maintoclass;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// �ʵ� ����
		// ��ü �κ�
		Scanner sc = new Scanner(System.in);
		
		// ���� �κ�
		double number1; double number2;
		
		// ��� ���� �κ�
		
		// ���ϱ� �κ�
		double plusResult;
		// ���� �κ�
		double minusResult;
		// ���ϱ� �κ�
		double multiplyResult;
		// ������ �κ�
		double divideResult;
		
		// ���۷��̼� �κ�
		System.out.print("ù��° ���� �Է� : ");
		number1 = sc.nextDouble();
		System.out.print("�ι�° ���� �Է� : ");
		number2 = sc.nextDouble();
		
		sc.close();
		
		// ���ϱ� �κ�
//		plusResult = number1 + number2;
//		System.out.println(plusResult);
//		// ���� �κ�
//		minusResult = number1 - number2;
//		System.out.println(minusResult);
//		// ���ϱ� �κ�
//		multiplyResult = number1 * number2;
//		System.out.println(multiplyResult);
//		// ������ �κ�
//		if(number2==0) {
//			System.out.println("���ڸ� 0���� ������ ������");
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
			System.out.println("���ڸ� 0���� ������ ������");
		} else {
			divideResult = number1 / number2;
			System.out.println(divideResult);
		}
		return divideResult;
	}
		
}
