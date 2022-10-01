package ch03;

public class Ex03 {
	public static void main(String[] args) {
		
		// 자료형[] 변수명 = {값1, 값2, 값3};
		
		int[] nums = {10, 20, 30, 40, 50, 60};
		
		// System.out.println(nums.length);
		
		
		/**
		  	int[] nums = new int[3];
		  	nums[0] = 10;
		  	nums[1] = 20;
		  	nums[2] = 30;
		 */
		
		
		// for 문
		for (int i = 0; i < nums.length; i++) {		// 0, 1, 2, 3
			System.out.println(nums[i]);
		}
		
		System.out.println("==============");
		
		// 향상된 for 문
		for (int num : nums) {
			System.out.println(num);
		}

	}
}
