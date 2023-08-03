package com.arcon.intro01;

public class Review4Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<6;i++) {
			System.out.print(i + "번째: ");
			if(i%2 == 0) {
				System.out.println("짝수");
			} else {
				System.out.println("홀수");
			}
		}
		
		String[] names = {"K1", "K2", "K3", "K4", "K5"};
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		for (String name : names) {
			System.out.println(name);
		}
		int index = 0;
		while (index<names.length) {
			System.out.println(names[index]);
			index++;
		}
	}

}
