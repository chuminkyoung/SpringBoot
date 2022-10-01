package ch05;

public class C extends B {
	int numC = 30;
	
	public C() {
		// super(); -> 기본생성자
		System.out.println("C 생성자");
	}
	
	void methdC() {
		System.out.println("메서드 C!");
	}
}

// 호출순서
// C -> B -> A
// 완료순서
// A -> B -> C
