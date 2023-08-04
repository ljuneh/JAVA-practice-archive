package com.day05;

public class BubleSort {
	public static void main(String[] args) {
		int[] scores = {60,50,95, 80, 70};
		bubleSort(scores);
		for(int i=1;i<scores.length;i++) {
			System.out.println(scores[i]);
		}
		
	}
	public static void bubleSort(int[] arrays) {
		for(int i=0;i<arrays.length-1;i++) {
			boolean isSwap = false;
			for(int j=0;j<arrays.length-i-1;j++) {
				if(arrays[j]>arrays[j+1]) {
					int temp = arrays[j];
					arrays[j]=arrays[j+1];
					arrays[j+1]=temp;
					isSwap = true;
				}
			}
			if(!isSwap) {
				break;
			}
		}
	}
}
