package study.class01;

public class Main {
	public static void main(String[] args) {
		// ��ü�� �����ϰ� �ʱ�ȭ : ������Ÿ�� ������(��� Ŭ������ ��ü��) = new Ŭ������();
		Student student = new Student();
		System.out.println(student);
		
		student.setsName("ȫ�浿");
		String name = student.getsName();
		System.out.println(name);
	}
}
