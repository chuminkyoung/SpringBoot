package ch02;

public class Ex04 {
	public static void main(String[] args) {
		// 숫자 -> 10보다 크고 100보다 작은  수인지 체크
		
		int num = 30;
		boolean result = num > 10 && num < 100;
		System.out.println(result);
		
		char ch = 'A';
		boolean result2 = ch == 'A' || ch == 'B';
		System.out.println(result2);
		
		boolean result3 = false;
		System.out.println(!result3);	// false -> true
		
		
		int num2 = 100;
		num2 += 2; 		// num2 = num2 + 2;		// 102
		num2 += 2; 		// num2 = num2 + 2; 	// 104
		num2 *= 10; 	// num2 = num2 * 10; 	// 1040
		
		System.out.println(num2);
		
			
		
		
		// 조건 연산자(삼항 조건 연산자)
		// (조건식) ? 참일 때 : 거짓일 때
		
		int num3 = 20;
		String result4 = num3 > 30 ? "30보다 크다" : "30보다 작거나 같다.";
		
		System.out.println(result4);
	}
}
