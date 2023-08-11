package day10.review;

import java.util.List;
import java.util.Scanner;

public class ReviewMain04 {
	public static void main(String[] args) {
		int size = 3;
		int pivot = 5;
		Scanner sc = new Scanner(System.in);

		int[] arr = inputProcess(sc, size);
		sc.close();
		compareNum(arr, pivot);
		List<?> list;
	}
	
	public static int[] inputProcess(Scanner sc, int size) {
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++) {
			System.out.print("정수 >>>");
			arr[i] = sc.nextInt();
		}
		return arr;
	}
	public static void compareNum(int[] arr, int pivot) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<pivot) {
				System.out.println(arr[i]+"는 "+pivot+"보다 작다");
			}
		}
	}
}
