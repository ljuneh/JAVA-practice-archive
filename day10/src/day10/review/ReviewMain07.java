package day10.review;

public class ReviewMain07 {
	public static void main(String[] args) {
		Employee employee = new Employee(1,"Á÷¿ø1",1000);
		System.out.println(employee.getEmpNo());
		System.out.println(employee.getName());
		System.out.println(employee.getSalary());
		
		employee.setSalary(3000);
		System.out.println(employee.getSalary());
		System.out.println(employee.getSalaryForYear());
	}
}