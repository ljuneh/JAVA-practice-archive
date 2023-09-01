package study.day18;

public class Main01 {
	public static void main(String[] args) {
		long lSum = 0L;
		int iFirst = 200; int iSecond =500;
		double dFirst = 200.123; double dSecond = 500.123;
		
		double dResult01 = iSecond/iFirst;
		
		long lBeforeTime = System.currentTimeMillis();
		for(int i=0; i<1000000; i++) {
			for(int j=0; j<5000; j++) {
				lSum += i*j;
			}
		}
		long lAfterTime = System.currentTimeMillis();
		
		double dResult02 = dFirst/dSecond;
		
		System.out.println("합계: " + lSum);
		System.out.println("실행시간: " + (lAfterTime));
	}
}