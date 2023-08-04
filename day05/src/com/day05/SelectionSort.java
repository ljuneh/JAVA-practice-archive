package com.day05;

public class SelectionSort {
	public static void main(String[] args) {
		int[] scores = {60,50,95, 80, 70};
		selectionSort(scores);
		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i]);
		}
	}
	public static void selectionSort(int[] arrays) {
		for(int i=0; i<arrays.length-1; i++) {
			int minIndex = i;
			for(int j=i+1; j<arrays.length; j++) {
				if(arrays[minIndex]>arrays[j]) {
					minIndex = j;
				}
			}
			if(minIndex!=i) {
				int temp = arrays[minIndex];
				arrays[minIndex] = arrays[i];
				arrays[i] = temp;
			}
		}
	}
}
