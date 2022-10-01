package ch06;

public abstract class Animal {
	int num;
	
	// abstract (추상적)
	public abstract void move();
}

// 추상클래스는 -> 객체 생성 x (미구현된 기능)
// -> 하위 클래스에서 미구현된 기능을 구현 -> 사용가능

// -> 하위 클래스가 따라야 할 표준을 정의

// -> 특정한 조건 하 객체가 생성
// (+ 미구현된 기능을 구현함으로써)

// 메서드 내부, 멤버 변수