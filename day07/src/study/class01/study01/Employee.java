package study.class01.study01;

public class Employee {
	// 필드(속성) 영역
	private int iEmpNo;
	private String sEmpName;
	private double dSalary;
	
	// 기본 생성자
	public Employee() {
		
	}
	
	// 인자있는 생성자
	public Employee(int iEmpNo, String sEmpName, double dSalary) {
		this.iEmpNo = iEmpNo;
		this.sEmpName = sEmpName;
		this.dSalary = dSalary;
	}
	
	// Getter/Setter
	public int getEmpNo() {
		return iEmpNo;
	}

	public void setEmpNo(int empNo) {
		this.iEmpNo = empNo;
	}

	public String getsEmpName() {
		return sEmpName;
	}

	public void setsEmpName(String sEmpName) {
		this.sEmpName = sEmpName;
	}

	public double getdSalary() {
		return dSalary;
	}

	public void setdSalary(double dSalary) {
		this.dSalary = dSalary;
	}
	
	// 메소드 영역 - 동적 메소드
	/**
	 * 월급에서 빠지는 금액
	 * @param ratio 세금 비율
	 * @return 빠지는 금액
	 */
	public double getReturnTax(double ratio) {
		// tax 금액 계산
		double result = dSalary*(ratio/100);
		return result;
	}
	
	// overloading
	public double getReturnTax(double ratio, int months) {
		double result = 0;
		if(months ==12) {
			result = ((dSalary*months)+(dSalary*1.3))*ratio/100;
		} else if((months>=1)&&(months<12)) {
			result = dSalary*months*ratio/100;
		}
		return result;
	}
	public static void test() {
		System.out.println("test");
	}
}
