package ch02;

public class Ex08 {
	public static void main(String[] args) {
		int total = 0;
		int num = 1;									// 초기화식
		
		while(num <= 100) {								// 조건식
			total += num; 	// total = total + num;
			num++;			// num = num + 1;			// 증감식
		}
		System.out.println(total);
	}
}
