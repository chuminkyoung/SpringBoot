package ch03;

public class Ex02 {
	public static void main(String[] args) {
		
		// 배열
		// -> 값을 저장하는 여러개의 공간을 생성하는 방법
		
		// 자료형[] 변수명 = new 자료형[공간의 갯수];
		// 자료형 변수명[] = new 자료형[공간의 갯수];
		
		// 1. 배열은 동일한 자료형으로 구성
		// 2. 동일한 공간의 크기로 연속되게 구성
		// 3. 공간의 크기로 다음 위치 쉽겍 유추 가능
		// 4. 요소의 위치로 접근이 쉽다
		// 5. [] -> 인덱스 연산자
		// 		 -> 인덱스는 위치 숫자 (0, 1, 2, 3, 4, ...)
		
		int[] nums = new int[4];	// int 변수가 4개
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		nums[3] = 40;
		
		/**
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		*/
		
		for(int i = 0; i <= 3; i++) { 		// 0, 1, 2, 3
			System.out.println(nums[i]);	// i -> index의 약자
		}
		
		// for -> i, j, k ...
		
		
	}
}
