# 객체(Object) - 사물, 대상

예) 자동차
    - 구성요소 - 멤버 변수
        - 바퀴, 연료, 엔진 ...

    - 대상의 행동 - 메서드
        - 운행


class Car {
    멤버변수

    메서드
}

클래스 - 객체 설계도

객체 


메모리 영역

데이터 영역 - 클래스 파일, 상수, 정적인 영역
스택 영역 - 메서드(함수)가 기능하기 위한 메모리 영역 -> 기능 다하게 되면 제거
힙 영역 - 객체가 생성되면 공간을 할당 받는 메모리 영역

스택(Stack) - 쌓다
큐(Queue) - 기다리다


printf ("name=%, grade=%d", "이름", 3)
%s -> 문자
%d -> 숫자
%f -> float



# 상속

class 하위 클래스 extends 상위 클래스 {

}

생성자 메서드 - 객체 생성 기능

컴파일러가 자동 추가
1. 기본 생성자


참고) 모든 메서드에 정의되어 있는 지역변수, 메서드
this : 지역변수 : 클래스 내부에서 생성된 객체의 주소를 참조하는 지역변수
this() : 생성자 메서드

super : 지역변수 : 생위 클래스로 생성된 객체의 주소를 참조하는 지역변수
super() : 상위 클래스의 생성자 메서드


객체 instanceof 클래스 자료형
클래스 자료형으로 생성된 객체인지 확인



# 상속
추상클래스

추상적 <--> 구체적
(정해지지않은)
- 공통적인

class 클래스명{
    변수

    메서드: 구체적
}

int add(num1, num2){
    int result = num1 + num2;

    return result;
}

add(10, 20);

메서드의 구현 부분이 정해지지 않은 클래스

    - abstract class
        public abstract ...

    - 미 구현된 메서드 -> 객체 생성 x



# 인터페이스(interface): 클래스의 일종
- 설계에 초점을 두고 만든 클래스의 일종
- 추상 메서드 정의만 염두해 두고 만든 클래스의 일종

int add(int num1, int num2);    // 컴페일러가 당연히 추상 메서드로 인식. public abstract

implements: 구현에 초점을 맞춤