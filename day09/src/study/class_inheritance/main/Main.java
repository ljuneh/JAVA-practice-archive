package study.class_inheritance.main;

import study.class_inheritance.BusinessPerson;
import study.class_inheritance.Person;

// 자바의 모든 클래스 Object 클래스를 상속함. B(하위) extend A(상위)
public class Main {
	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println(p1);
		
		Person p2 = new Person("직원1");
		System.out.println(p2);
		
		BusinessPerson p3 = new BusinessPerson();
		System.out.println(p3);
		BusinessPerson p4 = new BusinessPerson("직원2", "회사1");
		System.out.println(p4);
	}
}
