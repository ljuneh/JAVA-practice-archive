package study.class01;

public class Main02 {
	public static void main(String[] args) {
		int iEmpNo;
		String sEmpName;
		double dSalary;
		
		dSalary = 1000;
		
		Main02 main = new Main02();
		System.out.println(main.getReturnTax(dSalary, 7.5));
		
	}
	public double getReturnTax(double dSalary, double ratio) {
		return (dSalary*ratio/1000);
	}
}
