package study.access01;

import study.access.AcessTest;

public class Main {
	// private: 선언된 클래스 안에서만 직접 접근 가능
	// (package): 같은 패키지의 클래스들에서 직접 접근 가능
	// protected: 같은 패키지에 있거나 상속하는 클래스에서 직접 접근 가능
	// public: 어디에서라도 직접 접근 가능
	public static void main(String[] args) {
		AcessTest acessTest = new AcessTest();
		
	}
}
