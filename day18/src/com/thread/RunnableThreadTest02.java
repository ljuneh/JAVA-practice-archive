package com.thread;

public class RunnableThreadTest02 {

	public static long lSum1 = 0L;
	public static long lSum2 = 0L;
	public static long lSum3 = 0L;
	public static long lSum4 = 0L;
	
	public static long lTime1 = 0L;
	public static long lTime2 = 0L;
	public static long lTime3 = 0L;
	public static long lTime4 = 0L;
	
	public static void main(String[] args) {
		Runnable threadFirst = new RunnableThread02(0, 250000, 1);
		Runnable threadSecond = new RunnableThread02(250001, 500000, 2);
		Runnable threadThird = new RunnableThread02(500001, 750000, 3);
		Runnable threadForth = new RunnableThread02(750001, 1000000, 4);
		
		Thread thread1 = new Thread(threadFirst);
		Thread thread2 = new Thread(threadSecond);
		Thread thread3 = new Thread(threadThird);
		Thread thread4 = new Thread(threadForth);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		long lBeforeTime = System.currentTimeMillis();
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		long lAfterTime = System.currentTimeMillis();
		
		System.out.println("연산합계: " + (lSum1 + lSum2 + lSum3 + lSum4));
//		System.out.println("시간합계: " + (lTime1 + lTime2+ lTime3 + lTime4));
		System.out.println("시간합계: " + (lAfterTime - lBeforeTime));
	}

}
