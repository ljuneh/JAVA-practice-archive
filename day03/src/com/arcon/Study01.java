package com.arcon;

public class Study01 {
	public static void main(String[] args) {
		for(int i =1; i<=3; i++) {
			System.out.println("JAVA "+i );
			String[] strArray = new String[3];
			strArray[i-1] = ("JAVA "+i);
		}
		int[] iCountArr = {3,4,5,4,5,6,7};
		char[] cInfoArr = {'a','b','c','d','e','f','g','a','b','c','d','e','f','g'};
		int index=0;
		int nextindex = 0;
		Loop1:
		for(int i=0;i<iCountArr.length;i++) {
			int buffer = iCountArr[i];
			nextindex = index + buffer;
			Loop2:
			for(int j = index; j<nextindex; j++) {
				if(j>=cInfoArr.length) break Loop1;
				System.out.print(cInfoArr[j]);
			}
			System.out.println();
			index = nextindex;
			
		}
	}
}
