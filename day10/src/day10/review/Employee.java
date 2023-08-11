package day10.review;

public class Employee {
	private int empNo;
	private String name;
	private double salary;
	private int deptNo;
	
	public Employee() {
		
	}
	public Employee(int empNo, String name, double salary) {
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public double getSalaryForYear() {
		return salary*12;
	}
}
