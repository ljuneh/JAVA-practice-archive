package com.day05;

public class InsertionSort {
	public static void main(String[] args) {
		int[] scores = {60,50,95, 80, 70};
		insertSort(scores);
		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i]);
		}
	}
	
	public static void insertSort(int[] arrays) {
		for(int i=1; i<arrays.length;i++) {
			int insertKey = arrays[i];
			int j = i-1;
			while(j>=0 && arrays[j]>insertKey) {
				arrays[j+1] = arrays[j];
				j--;
			}
			arrays[j+1] = insertKey;
		}
	}
}
