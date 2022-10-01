package ch01;

public class Ex03 {
	public static void main(String[] args) {	// 작은 자료형 --> 큰 자료형 (묵시적 형변환)
		byte num0 = 100; 		// 1byte
		int num1 = num0;		// 4byte 			// byte -> int (자동) -> 묵시적 형변환
		long num2 = num1;		// 8byte			// int -> long (자동) -> 묵시적 형변환
	}
}
