package com.day05;

public class Study01 {

	public static void main(String[] args) {
		
		long startMillsTime = System.currentTimeMillis(); 
		long startNanosTime = System.nanoTime();
		System.out.println("Start: Hello World!!!");
		for(int i = 0; i < 1000; i ++)
		{
			for(int j = 0; j < 1000; j++)
			{
				System.out.println(1);
			}
		}
		System.out.println("End: Hello World!!!");
		long endMillsTime = System.currentTimeMillis();
		long endNanosTime = System.nanoTime();
		
		long duringMillsTime = (endMillsTime - startMillsTime);
		long duringSecsTime = (endMillsTime - startMillsTime)/1000;
		long duringMicrosTime = (endNanosTime - startNanosTime)/100000; 
		System.out.println("Mills:" + duringMillsTime);
		System.out.println("Seconds:" + duringSecsTime);
		System.out.println("Micros:" + duringMicrosTime);

	}

}
