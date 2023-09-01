package com.thread;

public class RunnableThreadTest {
	public static void main(String[] args) {
		Runnable threadFirst  = new RunnableThread();
		Runnable threadSecond  = new RunnableThread();
		Runnable threadThird  = new RunnableThread();
		Runnable threadForth  = new RunnableThread();
		
		Thread thread1 = new Thread(threadFirst);
		Thread thread2 = new Thread(threadFirst);
		Thread thread3 = new Thread(threadFirst);
		Thread thread4 = new Thread(threadFirst);
		
		
		
	}
}
