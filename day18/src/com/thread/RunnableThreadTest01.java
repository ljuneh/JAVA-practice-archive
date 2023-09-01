package com.thread;
public class RunnableThreadTest01 {

	public static void main(String[] args) {
		Runnable threadFirst = new RunnableThread01(0, 250000, 1);
		Runnable threadSecond = new RunnableThread01(250001, 500000, 2);
		Runnable threadThird = new RunnableThread01(500001, 750000, 3);
		Runnable threadForth = new RunnableThread01(750001, 1000000, 4);
		
		Thread thread1 = new Thread(threadFirst);
		Thread thread2 = new Thread(threadSecond);
		Thread thread3 = new Thread(threadThird);
		Thread thread4 = new Thread(threadForth);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		System.out.println("main 쓰레드를 종료합니다.");
	}

}
