package ch03;

public class Ex01 {
	public static void main(String[] args) {
		
		// 배열 -> 값을 저장하는 여러개의 공간을 생성하는 방법
		// 자료형[] 변수명 = new 자료형[공간의 갯수];
		
		// 학생 100명 한테 001~100 까지 학번 부여
		// int studentId1 = 202201001;
		// int studentId2 = 202201002;
		
		int[] studentID = new int[100]; 	// 100개의 공간이 만들어짐
		for(int num = 1; num <= 100; num++) {
			studentID[num-1] = 202201000 + num;
		}
		
		System.out.println(java.util.Arrays.toString(studentID));
		
	}
}
