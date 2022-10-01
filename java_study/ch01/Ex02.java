package ch01;

public class Ex02 {
	public static void main(String[] args) {
		byte num1 = 100; 					// 정수형 1byte 		// int 100 -> byte 100 		// -126 ~ 125 공간의 범위 내에서 사용 가능
		short num2 = 200;					// 정수형 2byte 		// int 200 -> short 200
		int num3 = 300;						// 정수형 4byte
		long num4 = 400;					// 정수형 8byte		// int 400 -> long 400
		long num4_ = 4000000000L; 	// long 		
		
		float num5 = 10.56F; 				// 실수형 4byte		// 공간의 실수
		double num6 = 100.123;			// 실수형 8byte
		
		char ch = 'A';							// 문자형 2byte 		//  char -> 문자 하나
		String str = "word";
		
		boolean bool = true;				// 논리형 1byte
		boolean bool2 = false;
	}
}
