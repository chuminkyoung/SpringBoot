package ch02;

public class Ex02 {
	public static void main(String[] args) {
		int num = 100;
		int num2 = num++; 	// 1) num  = num2 (대입)   		// 2) num = num +1 (연산)
		System.out.println("num = " + num + ", num2 = " + num2);
		
		int num3 = 100;
		int num4 = ++num3;	// 1) num3 = num3 + 1 (연산) 	// 2) num4 = num3 (대입)
		System.out.println("num3 = " + num3 + ", num4 = " + num4);
	}
}
