package day10.review;

import java.util.Arrays;
import java.util.Scanner;

public class ReviewMain05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = centerValue(sc);
		sc.close();
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static int[] centerValue(Scanner sc) {
		System.out.print("size of array : ");
		int arraySize = sc.nextInt();
		System.out.print("centerValue : ");
		int centerValue = sc.nextInt();
		
		int[] arr = new int[arraySize];
		arr[arraySize/2] = centerValue;
		return arr;
	}
}
