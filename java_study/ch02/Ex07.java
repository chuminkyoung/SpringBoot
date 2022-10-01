package ch02;

public class Ex07 {
	public static void main(String[] args) {
		String fruit = "Mango";
		
		switch (fruit) {
			case "Apple" :
				System.out.println("사과");
				break;
			case "Orange" :
				System.out.println("오렌지");
				break;
			case "Banana" :
				System.out.println("바나나");
				break;
			case "Melon" :
				System.out.println("멜론");
				break;
			default :
				System.out.println("없엉");
		}
	}
}
