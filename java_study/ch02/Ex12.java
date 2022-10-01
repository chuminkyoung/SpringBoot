package ch02;

public class Ex12 {
	public static void main(String[] args) {
		
		for(int num = 1; num <= 100; num++) {
			
			if(num % 2 == 1) {	// 홀수는 건너 뛰기 -> 짝수만 남는다.
				continue;
			}
			
			if(num == 50) {		// 반복 중단
				break;
			}
			
			System.out.println(num);
			
		}
	}
}
