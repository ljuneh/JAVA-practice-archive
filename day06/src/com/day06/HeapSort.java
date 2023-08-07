package com.day06;

public class HeapSort {
	public static void main(String[] args) {
		int[] scores = {60,50,95,80,70,60,50,95,80,70};
		heapSort(scores);
		for(int sc:scores) {
			System.out.println(sc);
		}
	}
	public static void heapSort(int[] arr) {
		int n = arr.length;

	    // Build max heap
	    for (int i = n / 2 - 1; i >= 0; i--) {
	        heapify(arr, n, i);
	    }

	    // Extract elements from heap one by one
	    for (int i = n - 1; i > 0; i--) {
	        int temp = arr[0];
	        arr[0] = arr[i];
	        arr[i] = temp;

	        // Call heapify on the reduced heap
	        heapify(arr, i, 0);
	    }
	}
	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
	    int l = 2 * i + 1; // Left child
	    int r = 2 * i + 2; // Right child

	    if (l < n && arr[l] > arr[largest]) largest = l;
	    if (r < n && arr[r] > arr[largest]) largest = r;

	    if (largest != i) {
	        int swap = arr[i];
	        arr[i] = arr[largest];
	        arr[largest] = swap;

	        // Recursively heapify the affected sub-tree
	        heapify(arr, n, largest);
	    }
	}
}
