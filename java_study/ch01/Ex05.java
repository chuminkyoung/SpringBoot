package ch01;

public class Ex05 {
	public static void main(String[] args) {
		// 정수 0,1 < 실수 0~1(무한대, 더 정밀한 숫자)
		
		int num1 = 1000;
		long num3 = 20000000L;
		float num2 = num1;
		float num4 = num3;
		
		double num5 = num3;
		double num6 = num1;
		
		// 더 큰자료형으로 자동 형변환
		// 더 정밀한 자료형 자동 형변환
		
		// 묵시적 형변환(자동 형변환)
		// byte --> short --> int --> long --> float(실수) --> double(실수)
		
		// 명시적 형변환
		// -> 자료 유실이 발생할 가능성이 있으므로 의사 표현을 해야한다.
		// (int)num
	}
}
