// mdn 문서 참조 https://developer.mozilla.org/ko/

// javascript 공부
// https://github.com/yonggyo1125/curriculum300H/tree/main/2.%EC%9B%B9%ED%91%9C%EC%A4%80(48%EC%8B%9C%EA%B0%84)


var 변수명 = 값;

- 기본 자료형
    - 숫자, 문자, 논리형(tru, false), null, nudefined

    - undefined - 값을 지정x
    - null = 엇이 없음을 지정

- 객체 - 변수에 담기는 값은 참조 주소 값

//

typofo 연산자 -> 변수의 타입

console.log(변수);

기본 자료형  + 객체 -> 자바스크립트는 모두 객체로 되어있다.

//

선언자
- var -> 요즘 사용 잘 안함
- let
- const

//

== 값이 같은지만 체크
!=

=== 자료형 + 값이 일치
!==

var num = 10;
var num = "10";


false로 인식하는 값
-> false, 0, nulll, undefined, ""
false로 인식하는 값 이외의 값은 전부 true

//

Symbol - 중복이 없는 값


객체(Object) 리터럴
객체 - {속성명 : 값 , 속성명 : 값 ...}

값 - 변수와 동일
    - 기본 자료형(원시타입)
        -> 숫자, 문자, 논리값, null, undefined ...
    - 객체

// 

객체 속성값 접근
.(마침표 연산자)

var person = {
    name : "이름", 
    age : 30
};

person;
person.name;
person.age;

person.name = "새로운 값";

객체에 없는 속성값에 값을 새로 지정 -> 추가
person.address = "주소!";

자바 객체에서는 값을 동적 추가x
자바스크립트 객체는 값을 동적으로 추가o

삭제 - delete person.age;


//

값 -> 기본 자료형, 객체
   -> 함수 객체

function 함수명 ( 매개변수 , ... ){
    // 함수가 수행되는 부분

    return 반환값;
}

함수객체 -> 함수 속성명
        -> 함수 실행 (속성명());

    var person = {
    name : "이름", 
    age : 30,
    showInfo : function info(){
        console.log(this.name, this.age);
        }
    };
    person.showInfo();



//



function Person(){
    this.name = "이름";
    this.age = 40;
}
var p1 = new Person(); -> Person {name: '이름', age: 40} // 고정된 값


// 함수 객체 -> 객체 생성
//         (상속)
function Person(name, age){
    this.name = name;
    this.age = age;
}


//


console.dir(a) // dir 은 a에 포함된 정보를 확인할 수 있다.


Function 생성자 객체
- apply, call, bind, ...

function Person(){

}

-> 함수 객체 생성

prototype
- contructor
- [[Prototype]] __proto__ : 상속을 받은 객체 : Fuction 생성자 객체

자바 상속 -> 메모리 포함관계
자바스크립트의 상속 -> 객체와 객체의 연결 관계 (참조 --> __proto__)

prototype
__proto__ // [[Prototype]] -> 상위 객체의 연결 링크


Fuction 생성자 함수 객체
    -> __proto__

function 함수명(){}  // 함수객체


생성자.prototype
    - .apply
    - .call
    - .bind
    ...
prototype 하위 메서드
    -> 하위 객체와 연결관계가 성립되면 접근 가능한 메서드
    (자바의 인스턴스 메서드)

객체 생성의 과정 -> 상속의 과정



new 연산자

1) 생성자.prototype과 상속
2) 초기화


함수객체 -> 1급 객체
1) 생성자
    - prototype
        - constructor : 생성자
    - [[Prototype]] __proto__

    예) 생성된 객체
    - [[Prototype]] __proto__


생성자.prototype -> 상속을 받은 하위 객에서 사용할 수 있는 메서드 정의
(생성자 객체 -> 클래스와 비슷, 생성자.prototype -> 클래스의 인스턴스 메서드)

// function Person(name, age){
//     this.name = name;
//     this.age = age;
// }
// var p1 = {};
// p1.__proto__ = Person.prototype; 
// -> p1.에 __proto__링크를 연결하고  = Person. 상속이 발생한다.


객체 속성값 = 기본형(원시타입), 객체

함수 객체

var person = {
    name : "이름",
    age : 40,
    showInfo : function(){
        console.log(this.name, this.age);
    }
}

var func = person.showInfo;

//

class Person {
    public String name;
    private int age;

    public void showInfo(){
        
    }

}
    힙
        name
        age


//

function Person(name, age){
    this.name = name;
    this.age = age;
    this.showInfo = function(){
        console.log(this.name, this.age);
    }
}

var p1 = new Person("이름1", 30);   // Person.prototype
    - name
    - age
    - showInfo

var p2 = new Person("이름2", 40);
    - name
    - age
    - showInfo


//


자바스크립트에서 함수 호출
func()
-> 함수 객체
-> 실행 문맥 객체(Exection Context - EC)
    - 내부에 정의된 변수(지역변수) -> 가장 상위에 정리
    - 외부에 정의된 변수를 사용하는지?
        -> 외부 연결
        -> 함수객체 내부에서 외부 연결된 변수 접근(전역변수)


함수객체(일급 객체) - 값
1) 생성자


Global EC 객체
    - 전역변수 : a,b
    - window 객체 바인딩

EC Outer 객체
    - 내부에 정의된 변수 a,b

EC inner 객체
    - 내부에 정의된 변수 : c,d
    - 외부에 정의된 변수를 사용
        -> 외부 변수 차마조([[Scopes]]) - 유효 범위 체인)
        -> EC Outer -a,b


function Outer(){
    var a = 10;
    var b = 20;
    return function inner(){
        var c = 30;
        var d = 40;
        return a + b + c + d;
    }
}
var inner = Outer();
inner(); --> 100;

//

function Outer(){
    var a = 10;
    var b = 20;
    return function inner(){
        var c = 30;
        var d = 40;

        return function inner2(){
            var e = 50;
            var f = 60;
            return a + b + c + d + e + f;
        };
    }
}
var inner = Outer();
var inner2 = inner();
inner2(); // -> 210

EC inner2 객체
    - 내부 정의된 변수 : e,f
    - 외부 변수 참조
        - EC Inner - c,d



자바 -> 객체 (인스턴스 - 힙)


//


-> JVM -> main() 호출 -> 애플리케이션 실행

크롬 브라우저 -> 애플리케이션   
    -> main()

    -> 자바스크립트가 동작하는 웹브라우저 페이지 -> 함수


GC(가비지 콜렉터 -  메모리 청소부)
- 더이상 참조하는 값이 엇는 객체의 변수값만 제거
- 클로져 -> 객체의 내부 상태가 유지되는 상태


/// ##



[1] var // 추천 안함
-> 함수 범위의 지역
-> 함수가 아니면 지역변수 X

1) 문제점
var i = "abc";
for (var i = 0; i < 10; i++){
    console.log(i);
}
i -> 10

2) 문제점
var text = "abc";
for (var i = 0; i < 10; i++){
    var text = "def";
}
text -> "def"
console.log(text); -> def



[2] ES6+
-> {} 범위 지역
let

1) 
let text = "abc";
for (let i = 0; i < 10; i++){
    let text = "def";
}
console.log(text);  -> abc



[3] const -> 상수 -> 변하지 않는 값들 
        - 모든 변수는 가급적이면 const로 선언
        - 다만 변경이 필요한 경우만 선택적으로 let

1)
const num1 = 100;
num1 = 200; -> 오류남

2)
     [주소]       [객체] -> 객체는 바뀐다.
const obj1 = { a : 1, b : 2 };
obj1.a = 10;
obj1; -> { a : 10, b : 2 };