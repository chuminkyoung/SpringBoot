package ch02;

public class Ex03 {
	public static void main(String[] args) {
		boolean result1 = true && true; 	// true
		boolean result2 = false && true; 	// false
		System.out.println(result1);
		System.out.println(result2);
		
		boolean result3 = true || false;	// true
		boolean result4 = false || true;	// true
		System.out.println(result3);
		System.out.println(result4);
	}
}
