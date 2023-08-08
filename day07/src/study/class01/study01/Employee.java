package study.class01.study01;

public class Employee {
	// �ʵ�(�Ӽ�) ����
	private int iEmpNo;
	private String sEmpName;
	private double dSalary;
	
	// �⺻ ������
	public Employee() {
		
	}
	
	// �����ִ� ������
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
	
	// �޼ҵ� ���� - ���� �޼ҵ�
	/**
	 * ���޿��� ������ �ݾ�
	 * @param ratio ���� ����
	 * @return ������ �ݾ�
	 */
	public double getReturnTax(double ratio) {
		// tax �ݾ� ���
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
