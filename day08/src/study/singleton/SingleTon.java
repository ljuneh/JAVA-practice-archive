package study.singleton;


public class SingleTon {
	private static SingleTon instance;
	private String name;
	
	private SingleTon() {}
	
	private SingleTon(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static SingleTon getInstance(String name) {
		if(instance == null) {
			instance = new SingleTon(name);
			System.out.println("������ " + "��ü�� �����մϴ�.");
		} else System.out.println("�̹� ������ " + "��ü�� �����մϴ�.");
		return instance;
	}
}
