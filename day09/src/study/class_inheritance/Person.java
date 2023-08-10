package study.class_inheritance;

public class Person {
	private String name;
	
	public Person() {
		System.out.println("Person() 持失切");
	}
	
	public Person(String name) {
		this.name = name;
		System.out.println("Person() 持失切");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("戚硯 : %s", this.name);
	}
}
