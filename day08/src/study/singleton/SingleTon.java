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
			System.out.println("생성한 " + "객체를 리턴합니다.");
		} else System.out.println("이미 생성된 " + "객체를 리턴합니다.");
		return instance;
	}
}
