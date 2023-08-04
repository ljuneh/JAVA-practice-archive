package com.day05;

public class Max {
	public static void main(String[] args) {
		int[] scores = {60,50,95, 80, 70};
		int maxInt = max(scores);
		System.out.println(maxInt);
		
	}
	public static int max(int[] arrays) {
		for(int i = 0; i<arrays.length-1; i++) {
			if(arrays[i]>arrays[i+1]) {
				int temp = arrays[i];
				arrays[i+1] = arrays[i];
				arrays[i] = temp;
			}
		}
		return arrays[arrays.length-1];
	}
}
