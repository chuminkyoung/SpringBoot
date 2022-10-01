package ch04;

public class Person {
	public String name;
	public int age;
	
	public Person(){
		this("이름없음",0);
		// this.name = "이름없움";
		// this.age = 0;
	}
	
	Person(String name, int age){
		System.out.println(this);
		// 객체가 생성 이후 -> 멤버 변수의 초기화
		this.name = name;
		this.age = age;
	}
	
	Person returnThis() {
		return this;
	}
	
	public void printInfo() {
		System.out.println(name + "," + age);
	}
}
