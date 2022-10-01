package ch04;

public class Student {
	// 멤버 변수
	public static int seriaNum;
	int studentId;  	// 학번
	String name; 		// 이름
	int ban;			// 반
	int grade; 			// 학년
	
	// static -> 정적인 (고정되어 있는)
	
	// 매개변수가 없는 생성자는 따로 정의 x
	// 컴파일시 자동 추가
	// 반환 자료형 x
	// 생성자 메서드 목적 -> 객체 생성, 명확한 목적
	// 반환값 명시 x
	// 기본 생성자
	// -> 생성자가 아무것도 정의 되지 않은 경우 -> 추가
	
	/**
	public Student(String studentName){
		// System.out.println("생성자 메서드 호출!");
		name = studentName;
	}
	*/
	
	// 멤버 메서드
	void study() {
		System.out.println(name + "가 공부한다.");
		
		// return void;
		// 반환값이 없는 함수 -> 반환 자료형 void (비어있다) 생략.
	}
	
	static void printinfo() {
		//System.out.println(studentId + ", " + name);
	}
}
