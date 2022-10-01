package ch06;

public class Ex01 {
	public static void main(String[] args) {
		// Animal animal = new Animal();
		
		Animal dog = new Dog();
		dog.move();
		
		Animal bird = new Bird();
		bird.move();
		
		dog.num = 10;
		System.out.println(dog.num);
	}

}

// 추상클래스는 -> 객체 생성 x (미구현된 기능)
// -> 하위 클래스에서 미구현된 기능을 구현 -> 사용가능
