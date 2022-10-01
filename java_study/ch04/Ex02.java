package ch04;

public class Ex02 {
	public static void main(String[] args) {
		/*
		int y = func(3);
		System.out.println(y);
		*/
		
		// 메서드 안에 정의된 num1, num2 ->
		// 메서드가 실행되는 동안에만 스택 메모리에 공간을 할당 받는다 -> 종료가 되면 메모리에서 해제
		// num1, num2 메서드 안에서만 유효
		// 메서드 안 ({ ... } --> 지역) -> 지역변수
		
		int result = add(10, 20);
		System.out.println(result);
	}
	
	// 2x + 1 = y
	static int func(int x) {	// x 값
		int y = 2 * x + 1;		// 연산하는 부분
		
		return y;				// y 값
	}
	// 메서드명(매개변수 ...);
	
	static int add(int num1, int num2) { 	// 지역 변수
		int result = num1 + num2;			// 연산
		
		return result;
	}
	
	
	/* Stack 스택구조
	 	- 가장 마지막에 투입한 것을 가장 먼저 꺼낼수 있고
	 	- 가장 처음에 투입한 것을 가장 나중에 꺼낼수 있는 구조
	 */
}
