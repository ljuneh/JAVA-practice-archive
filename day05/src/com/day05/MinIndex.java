package com.day05;

public class MinIndex {
	public static void main(String[] args) {
		int[] scores = {60,50,95, 80, 70};
		int minIndex = minIndex(scores);
		System.out.println(minIndex);
		System.out.println(scores[minIndex]);
	}
	public static int minIndex(int[] arrays) {
		int minIndex = 0;
		for(int j=1;j<arrays.length;j++) {
			if(arrays[minIndex]>arrays[j]) {
				minIndex = j;
			}
		}
		return minIndex;
	}
}
