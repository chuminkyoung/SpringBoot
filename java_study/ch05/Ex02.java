package ch05;

public class Ex02 {
	public static void main(String[] args) {
		B b = new C();
		B b2 = new D();
		
		//System.out.println(b instanceof  C); 	// b는 (상위클래스)C로부터 만들어진 객체인가 확인
		//System.out.println(b2 instanceof C);
		
		if(b2 instanceof C) {
			C c2 = (C)b2;
		}
		
		// C c = (C)b; 		// 출처표시
		// C c2 = (C)b2; 	// 출처표시
		
	}

}


// 묵시적 형변환
// -> 원래 데이터에 손실x

// 명시적 형변환
// -> 원래 데이터의ㅣ 손실 발생 가능성


// instannceof (자료 확인)