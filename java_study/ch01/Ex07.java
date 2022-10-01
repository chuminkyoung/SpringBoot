package ch01;

public class Ex07 {
	public static void main(String[] args) {
		/*
		int num1 = 10;
		int num2 = 3;
		int leftover = num1 % num2;		// 몫은 3, 나머지는 1
		System.out.println(leftover);
		*/
		
		// 40명 학생, 반 10개
		for(int i = 1; i <= 40; i++) {
			int roomNo = i % 10; 	// 0~9
			System.out.println("방번호 : " + (roomNo + 1) + ", 학생 " + i);
		}
	}
}
