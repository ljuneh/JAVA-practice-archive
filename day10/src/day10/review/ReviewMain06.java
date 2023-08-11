package day10.review;

import java.util.Arrays;
import java.util.Scanner;

public class ReviewMain06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("size of array : ");
		int arrSize = sc.nextInt();
		int[] arr1 = new int[arrSize];
		int[] arr2 = new int[arrSize];
		
		System.out.print("centerValue : ");
		int value = sc.nextInt();
		
		evenInput(arr2, value);
		System.out.println("arr2 : "+Arrays.toString(arr2));
		
		dynamicMakeArr(arr1, arr2);
		System.out.println("arr1 : "+Arrays.toString(arr1));
		
		
	}
	
	public static void dynamicMakeArr(int[] arr1, int[] arr2) {
		for(int i=0;i<arr2.length;i++) {
			int j=i-1;
			if(j>=0) {
				arr1[j]=arr2[i];
			}
		}
	}
	
	public static void evenInput(int[] arr, int value) {
		for(int i=0;i<arr.length;i++) {
			if(i%2 == 1) {
				arr[i] =value; 
			}
		}
	}
}
