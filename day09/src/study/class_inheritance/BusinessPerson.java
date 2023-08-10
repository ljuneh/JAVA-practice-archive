package study.class_inheritance;

public class BusinessPerson extends Person {
	private String company;
	
	public BusinessPerson() {
//		super(); // 생략가능
		System.out.println("BusinessPerson() 생성자");
	}
	public BusinessPerson(String name, String company) {
		super(name);
		System.out.println("BusinessPerson() 생성자");
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
		return String.format("이름: %s, 회사: %s", this.getName(), this.company);
	}
	
	
}
