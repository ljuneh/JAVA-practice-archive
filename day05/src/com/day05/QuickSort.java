package com.day05;

public class QuickSort {
	public static void main(String[] args) {
		int[] scores = {60,50,95,80,70,60,50,95,80,70};
		quickSort(scores, 0, scores.length-1);
		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i]);
		}
	}
	public static void quickSort(int[] arr, int low, int high) {
	    if (low < high) {
	        int pi = partition(arr, low, high);
	        quickSort(arr, low, pi - 1);
	        quickSort(arr, pi + 1, high);
	    }
	}

	public static int partition(int[] arr, int low, int high) {
	    int pivot = arr[high];
	    int i = (low - 1);
	    for (int j = low; j < high; j++) {
	        if (arr[j] < pivot) {
	            i++;
	            if (i != j) { 
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	    }
	    int temp = arr[i + 1];
	    arr[i + 1] = arr[high];
	    arr[high] = temp;
	    return i + 1;
	}

}
