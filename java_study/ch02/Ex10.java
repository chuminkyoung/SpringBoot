package ch02;

public class Ex10 {
	public static void main(String[] args) {
		
		int total = 0;
		
		// for(초기화식; 조건식; 증감식;){}
		for(int num = 1; num <= 100; num++) {
			total += num;
		}
		System.out.println(total);
		
	}
}
