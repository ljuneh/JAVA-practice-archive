package study.day14;

import java.util.Arrays;

public class MethodMain01 {
	public static void main(String[] args) {
		
//		countdown(10);
		int arr[] = {10,40,50,10,20,30,40,50};
//		int total = sumOfArray(arr);
//		System.out.println(total);
		int minmax[] = min_maxOfArray(arr);
		System.out.println(Arrays.toString(minmax));
		
	}
	
	public static void countdown(int count) {
		if(count<=0) return;
		
		for(int i=count; i>0; i--) {
			System.out.println(i+ " ");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static int sumOfArray(int[] arr) {
		int iTotal = 0;
		for(int i=0; i<arr.length; i++) {
			iTotal += arr[i];
		}
		return iTotal;
			
	}
	
	public static int[] min_maxOfArray(int[] arr) {
		int minIndex = 0;
		int maxIndex = 0;
		int[] result = new int[2];
		for(int i=0; i<arr.length; i++) {
			if(arr[minIndex]>arr[i]) {
				minIndex = i;
			}
			if(arr[maxIndex]<arr[i]) {
				maxIndex = i;
			}
		}
		
		result[0] = arr[minIndex];
		result[1] = arr[maxIndex];
		
		return result;
	}
}
