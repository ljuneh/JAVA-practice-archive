package study.singleton;

public class Main {
	public static void main(String[] args) { 
		SingleTon st1 = 
				SingleTon.getInstance("KHT1");
		System.out.println(st1);
		
		SingleTon st2 = 
				SingleTon.getInstance("KHT2");
		System.out.println(st2);
		
		System.out.println(st1.getName());
		System.out.println(st2.getName());
	}
}
