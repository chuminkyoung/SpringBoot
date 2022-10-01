package ch02;

public class Ex09 {
	public static void main(String[] args) {
		// do-while 문
		
		// do{
		// 	조건식이 참일때 실행되는 영역
		// }while(조건식);
		
		/*
		do {
			System.out.println("실행!");		// 우선 한번은 실행
		}while(false);
		*/
		
		int total = 0;
		int num = 1;
		
		do {
			total += num; 	//total = total + num;
			num++; 			// num = num + 1
		}while(num <= 100);
		System.out.println(total);
	}
}
