package study.class_inheritance.test;

public class Test1 {
	private int number1;
	
	public Test1() {}
	
	
	
	public int getNumber1() {
		return number1;
	}



	public void setNumber1(int number1) {
		this.number1 = number1;
	}



	public Test1(Test2 test2) {
		this.number1 = test2.getNumber2();
		
	}
}
