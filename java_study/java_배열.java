// 내장생성자 공부
// https://github.com/yonggyo1125/curriculum300H/tree/main/2.%EC%9B%B9%ED%91%9C%EC%A4%80(48%EC%8B%9C%EA%B0%84)/6~7%EC%9D%BC%EC%B0%A8(6h)%20-%20%EB%82%B4%EC%9E%A5%EA%B0%9D%EC%B2%B4



studentID1
studentID2 ... studentID100
int[] studentID = new int[100];

자바 배열
    - 1) 동일한 자료형
    - 2) 연속된 나열 구조


배열 객체 - 유사 배열 (자바의 LinkedList)

[]  // 0, 1, 2, ...

변수[0];
변수[1];
변수[2];

{ "0" : "apple" , "1" : "mango", "2" : "orange" }

배열객체
    - 속성명 : 인덱스 번호
    - 속성값 : 값(변수 값과 동일)
            -> 원시타입값, 객체
    
- 변수명[3] = "추가 내용"; -> 3번째 자리에 추가
- 변수명[1] = "수정 내용"; -> 1번째 내용 수정
- delete 변수명[0]; -> 0번째 내용 삭제


[] == new Array() -> 같은 내용

const frouits = new Array("apple", "mango", "orange");
fruits; -> ["apple", "mango", "orange"];



const fruits = { "0" : "apple", "1" : "mango", "2" : "orange" };
Object.setPrototypeOf(fruits, Array.prototype);
fruits;





생성자 객체 -> (상속) -> 객체
        -> 생성자.prototype 연결(상속)

웹브라우저 -> 자바스크립트 해석기(V8)
내장생성자 + 내장 객체


자바스크립트 코아 (ECMAScript)
    내장 생성자 객체
    Object
    String  *** 중요
    Number  *** 중요
    Boolean
    Array   *** 중요
    Function
    ...

    내장 객체 (생성없이 바로 사용 가능한 객체)
    Math 
        .round  - 반올림
        .ceil   - 올림
        .floor  - 버림
        .abs() ...

호스트 객체 - 자바스크립트 실행환경에서 추가된 객체 (브라우저 객체)
    window
        - document
        - screen
        - history
        - location
        - navigator ...