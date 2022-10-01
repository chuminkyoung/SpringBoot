package ch05;

public class B extends A {
	int numB = 20;
	
	public B() {
		// super(); -> 기본생성자 	// A();
		System.out.println("B 생성자");
	}
	
	void methodB() {
		System.out.println("메서드 B");
	}
}
