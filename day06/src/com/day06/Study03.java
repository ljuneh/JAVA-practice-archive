package com.day06;

import java.util.Scanner;

public class Study03 {
//	��¸޽��� ����
//		�հݸ޼���
//			���ڿ� ����
//		���հݸ޽���
//			���ڿ� ����
//	Ű����� 
//	������ �Է� �ް� 
//		����, ����, ���� �� ���� ����
//	�հ�� ����� ���
//		�հ�
//			�հ�����
//		���
//			�������
//	
//	�հ�/���հ� ó��
//		�հ��̸�
//			�� ������ ������ ���� 40�� �̻��̸鼭 
//			����� 60�� �̻��� ���
//		���հ��̸�
	
	public static void main(String[] args) {
		int iNlScore = 0; int iEngScore = 0; int iMathScore = 0;
		int iSume = 0;
		int iAvg = 0;
		
		Scanner sc = new java.util.Scanner(System.in);
		iNlScore = sc.nextInt(); iMathScore = sc.nextInt(); iEngScore = sc.nextInt();
		iAvg = (iNlScore+iMathScore+iEngScore)/3;
		
		
		
		if(((iNlScore>=40)&&(iEngScore>=40)&&(iMathScore>=40)) && (iAvg>=60)) {
			System.out.println("�����մϴ�, �հ��Դϴ�!");
		} else {
			System.out.println("���հ��Դϴ�");
		}
		
	}
}
