package ch04;

public class Ex04 {
	public static void main(String[] args) {
		Person p1 = new Person("이름", 40);
		System.out.println("p1 : " + p1);
		System.out.println("this : " + p1.returnThis());
		System.out.println(p1 == p1.returnThis());
		
		
	}
}
