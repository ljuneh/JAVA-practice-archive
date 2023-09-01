package com.thread;
public class RunnableThread02 implements Runnable{
	private int iStart;
	private int iEnd;
	private int iFlag;
	
	public RunnableThread02(int iStart, int iEnd,
			int iFlag) {
		this.iStart = iStart;
		this.iEnd = iEnd;
		this.iFlag = iFlag;
	}
	
	@Override
	public void run() {
		long lSum = 0;
//		long lBeforeTime = System.currentTimeMillis();
		for(int i = iStart; i < iEnd; i++) {
			for(int j = 0; j < 5000; j++) {
				lSum += i * j;
			}
		}	
//		long lAfterTime = System.currentTimeMillis();
		
		if(iFlag == 1) {
			RunnableThreadTest02.lSum1 = lSum;
//			RunnableThreadTest02.lTime1 = lAfterTime - lBeforeTime;
		} else if(iFlag == 2) {
			RunnableThreadTest02.lSum2 = lSum;
//			RunnableThreadTest02.lTime2 = lAfterTime - lBeforeTime;
		} else if(iFlag == 3) {
			RunnableThreadTest02.lSum3 = lSum;
//			RunnableThreadTest02.lTime3 = lAfterTime - lBeforeTime;
		} else if(iFlag == 4) {
			RunnableThreadTest02.lSum4 = lSum;
//			RunnableThreadTest02.lTime4 = lAfterTime - lBeforeTime;
		}
	}

}
