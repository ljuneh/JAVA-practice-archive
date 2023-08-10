package study.class_inheritance;

public class BusinessPerson extends Person {
	private String company;
	
	public BusinessPerson() {
//		super(); // ��������
		System.out.println("BusinessPerson() ������");
	}
	public BusinessPerson(String name, String company) {
		super(name);
		System.out.println("BusinessPerson() ������");
		this.company = company;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("�̸�: %s, ȸ��: %s", this.getName(), this.company);
	}
	
	
}
