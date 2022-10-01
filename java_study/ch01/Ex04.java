package ch01;

public class Ex04 {
	public static void main(String[] args) {	// 큰 자료형 --> 작은 자료형 (명시적 형변환)
		int num1 = 2000;
		byte num2 = (byte)num1;		// 1byte <-- 4byte		// 자료가 넘쳐도 담을 경우 앞에 (자료형) 명시 (자료 유실 발생)
		// 명시적 형변환
		
		System.out.println(num2);
	}
}
