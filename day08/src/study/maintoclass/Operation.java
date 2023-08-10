package study.maintoclass;

public class Operation {
		
	public Operation() {
		
	}
	
	public double addOperation(double number1, double number2) {
		double plusResult;
		plusResult = number1 + number2;
		System.out.println(plusResult);
		return plusResult;
	}
	public double minusOperation(double number1, double number2) {
		double minusResult;
		minusResult = number1 - number2;
		System.out.println(minusResult);
		return minusResult;
	}
	public double multiplyOperation(double number1, double number2) {
		double multiplyResult;
		multiplyResult = number1 * number2;
		System.out.println(multiplyResult);
		return multiplyResult;
	}
	public double divideOperation(double number1, double number2) {
		double divideResult = 100000;
		if(number2==0) {
			System.out.println("숫자를 0으로 나누지 마세요");
		} else {
			divideResult = number1 / number2;
			System.out.println(divideResult);
		}
		return divideResult;
	}
}
