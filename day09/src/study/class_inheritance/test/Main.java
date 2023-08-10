package study.class_inheritance.test;

public class Main {
	public static void main(String[] args) {
		Test2 test2 = new Test2();
		test2.setNumber2(10);
		
		Test1 test1 = new Test1(test2);
		
		System.out.println(test1.getNumber1());
		
		
	}
}
