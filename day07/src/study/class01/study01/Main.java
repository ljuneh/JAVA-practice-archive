package study.class01.study01;


public class Main {
	public static void main(String[] args) {
		Employee employee = new Employee(0,"",1000 );
		System.out.println(employee.getReturnTax(7.5));
		System.out.println(employee.getReturnTax(7.5, 1));
		Employee.test();
	}
}
