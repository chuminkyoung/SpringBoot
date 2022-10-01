package ch02;

public class Ex06 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int min;
		
		if(a <= b) {
			min = a;
		}else {
			min = b;
		}
		System.out.println(min);
		
		
		int min2 = a <= b ? a:b;
		System.out.println(min2);
	}
}
