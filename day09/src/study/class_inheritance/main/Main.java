package study.class_inheritance.main;

import study.class_inheritance.BusinessPerson;
import study.class_inheritance.Person;

// �ڹ��� ��� Ŭ���� Object Ŭ������ �����. B(����) extend A(����)
public class Main {
	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println(p1);
		
		Person p2 = new Person("����1");
		System.out.println(p2);
		
		BusinessPerson p3 = new BusinessPerson();
		System.out.println(p3);
		BusinessPerson p4 = new BusinessPerson("����2", "ȸ��1");
		System.out.println(p4);
	}
}
