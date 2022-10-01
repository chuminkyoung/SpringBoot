package ch02;

public class Ex05 {
	public static void main(String[] args) {
		int num = 8;
		if(num < 5) {
			System.out.println("num은 5보다 작다");
		}else if(num < 7) {
			// num은 5보다 크고 7보다 작은 조건
			System.out.println("num은 5보다 크고 7보다 작은 조건");
		}else {
			// 모든 조건이 거짓일때 실행되는 영역
			System.out.println("num은 7보다 크다");
		}
	}
}
