package day10.review;


import java.util.Scanner;

public class ReviewMain02 {
	public static void main(String[] args) {
		int a;
		int b;
		float c;
		float d;
		int pivot = 5;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է�");
		a = sc.nextInt();
		System.out.println("������ �Է�");
		b = sc.nextInt();
		System.out.println("�Ǽ��� �Է�");
		c = sc.nextFloat();
		System.out.println("�Ǽ��� �Է�");
		d = sc.nextFloat();

		sc.close();
		
		
		comparsion(a, pivot);
		comparsion(b, pivot);
		comparsion(c, pivot);
		comparsion(d, pivot);
		
	}	
	public static <T> void comparsion(T number, int pivot) {
		if(Double.parseDouble(String.valueOf(number))<pivot) {
			System.out.println(number+"�� "+pivot+"���� �۴�");
		}
	}
}
