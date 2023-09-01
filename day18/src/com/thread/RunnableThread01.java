package com.thread;
public class RunnableThread01 implements Runnable{
	private int iStart;
	private int iEnd;
	private int iFlag;
	
	public RunnableThread01(int iStart, int iEnd,
			int iFlag) {
		this.iStart = iStart;
		this.iEnd = iEnd;
		this.iFlag = iFlag;
	}
	
	@Override
	public void run() {
		long lSum = 0;
		long lBeforeTime = System.currentTimeMillis();
		for(int i = iStart; i < iEnd; i++) {
			for(int j = 0; j < 5000; j++) {
				lSum += i * j;
			}
		}	
		long lAfterTime = System.currentTimeMillis();
		
		if(iFlag == 1) {
			System.out.println("시간: " + iFlag + ":" + (lAfterTime - lBeforeTime));
		} else if(iFlag == 2) {
			System.out.println("시간: " + iFlag + ":" + (lAfterTime - lBeforeTime));
		} else if(iFlag == 3) {
			System.out.println("시간: " + iFlag + ":" + (lAfterTime - lBeforeTime));
		} else if(iFlag == 4) {
			System.out.println("시간: " + iFlag + ":" + (lAfterTime - lBeforeTime));
		}
	}

}
