package com.day06;

import java.util.Scanner;

public class Study02 {
	
	public static void main(String[] args) {
//		1. Ű���� : Scanner ��ü ����
//		2. �Է� ���� 
//			2.1 ����
//		3. �Է��� �� üũ
//		����̸鼭 
//			¦���� ���� 
//				��¦���١��� ����ϰ�
//			¦���� �ƴϸ� 
//				��Ȧ���١��� ����ϼ���.
//		����� �ƴϸ� 
//			������� �Է����ּ���.���� ����ϼ���.
		Scanner sc = new java.util.Scanner(System.in);
		int iInputValue = 0;
		
		iInputValue = sc.nextInt();
		
		if(iInputValue <= 0) {
			System.out.println("����� �Է�");
		} else {
			if(iInputValue%2 == 0) {
				System.out.println("¦����");
			} else {
				System.out.println("Ȧ����");
			}
		}
		
		sc.close();
		
	}
}
