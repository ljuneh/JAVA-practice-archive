package com.day16;

import java.util.Arrays;

public class Cal {
	public static void main(String[] args) {
		int ivalue1 = 10;
		int ivalue2 = 20;
		
		int iret0 = 0;
		int iret1 = 0;
		int iret2 = 0;
		double iret3 = 0;
		
		iret0 = add(ivalue1, ivalue2);
		iret1 = sub(ivalue1, ivalue2);
		iret2 = mul(ivalue1, ivalue2);
		iret3 = div(ivalue1, ivalue2);
		
		int arr[] = {10,20,30,40,50};
		printChangedArray(arr, 0, 100);
		printAcumulate(10, 10);
	} //main
	
	public static int add(int ivalue1, int ivalue2) {
		int iret0 = ivalue1 + ivalue2;
		if(iret0 < 0) {
			iret0 = -iret0;
		}
		System.out.println(iret0);
		return iret0;
	}
	
	public static int sub(int ivalue1, int ivalue2) {
		int iret1 = ivalue1 - ivalue2;
		if(iret1 < 0) {
			iret1 = -iret1;
		}
		System.out.println(iret1);
		return iret1;
	}
	
	public static int mul(int ivalue1, int ivalue2) {
		int iret2;
		if(ivalue1==0 || ivalue2==0) {
			iret2 = 0;
		} else {
			iret2 = ivalue1 * ivalue2;
		}
		System.out.println(iret2);
		return iret2;
	}
	
	public static double div(int ivalue1, int ivalue2) {
		double iret3;
		if(ivalue2==0) {
			System.out.println("ivalue2 : 0");
			iret3 = 1000000;
		} else {
			if(ivalue1 ==0) {
				iret3 = 0;
			} else {
				iret3 = (((double) ivalue1 / (double) ivalue2));
			}
			System.out.println(iret3);
		}
		return iret3;
	}
	
	public static void printChangedArray(int[] arr, int index, int value) {
		arr[index] = value;
		Arrays.toString(arr);
	}
	
	public static void printAcumulate(int startValue, int iteration) {
		System.out.println(startValue);
		for(int i = 0; i<iteration; i++) {
			startValue ++;
		}
		System.out.println(startValue);
	}
}
