package ch04;

public class Ex01 {
	public static void main(String[] args) {
		
		/*
		  	클래스명과 동일한 메서드(함수)
		  	-> 객체를 생성하는 기능
		  	-> 생성자
		 */
		
		// 기본자료형, 참조 자료형(클래스형 자료)
		// s1 -> main 함수에 정의되어 있는 지역변수
		// s1 -> new Student() 객체를 찾아갈 수 있는 주소(메모리) 값
		
		Student s1 = new Student();		// 객체를 만드는 기능
		System.out.println(s1);
		
		Student s2 = new Student();
		s2.name = "이름1";
		System.out.println(s2.name);
		
		// System.out.println(s1 == s2);
		Student s3 = s2;
		s3.name = "이름2";
		System.out.println(s2.name);
		System.out.println(s3.name);
		
		// s1.name = "학생명1";
		// s1.study();
		
		
		
		// 객체.멤버변수
		// 객체.메서드(); 
		
		// .(마침표) // 객체 외부에 있는 변수를 호출할수 있음
		
		// 클래스명과 동일한 명칭의 메서드 -> 생성자
		// 메서드 == 함수 -> 기능(연산)
		
		/**
		 	접근제한자 반환자료형 메서드명( 매개변수, ... ){
		  	//기능을 수행하는 부분
		  	
		  	return 반환값
		  	};
		 */
	}
}
