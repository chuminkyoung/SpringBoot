브라우저 - 자바스크립트 해석기 (자바스크립트 엔진 크롬 -V8)

공통 핵심 소스(ECMAScript)
    - 내장 생성자 객체
    - 내장 객체

호스트 객체(실행되는 (runtime) 환경에서 추가된 객체)
브라우저 객체 - 역할? 웹 페이지(웹 문서 - HTML) 출력
    Window -> window 객체 생성 

    window
        - document 객체
            -> 웹 문서를 조작 (HTML 요소를 조작하는 기능, 속성)
        - location
            -> 웹브라우저의 주소창을 통제하는 기능
                - assign()
                    -> 페이지 이동  location.assign("주소")
                    -> 히스토리 기록
                - reload() 
                    -> 새로고침
                - replace()
                    -> 페이지 이동  location.replace("주소")
                    -> 히스토리를 기록하지 않는 이동 (뒤로가기, 앞으로가기 x)
        - history 
            -> location.host="www.daum.net" -> 주소이동
            -> lenght : 웹페이지 이동 횟수 -> history; 로 확인 가능
            -> scrollRestoration : auto -> 스크롤 위치 복구 , 뒤로 가기 했을때 이전 페이지의 스크롤 위치 복구
                                 : manual -> 스크롤 위치 복구 x
            -> history.back()    -> 한단계 뒤로 이동
            -> history.forward() -> 한단계 앞으로 이동
            -> history.go(-2)    -> 여러단계를 이동
                음수 -> 뒤로
                양수 -> 앞으로
        - screen
        - navigator
        ...

    window.location -> location

    hash -> 웹페이지의 id값을 가지고 검색
    location.hash="footer"; -> 해당 id 위치로 이동


    window
        타이머
        - setInterval
        - setTimeout

        메세지 관련
        - alert (알림)
            -> window.alert("메세지!");
            -> alert("메세지!");
        - prompt
            -> const v = prompt("값을 입력하세요");
                v; -> 입력한 값이 나타남
        - confirm
            -> const result = confirm("정말 삭제하시겠습니까?")
                result;

        innerWidth
            -> 스크롤바를 제외한 넓이
        innerHeight
            -> 스크롤바를 제외한 높이
        outerWidth
            -> 스크롤바 포함한 넓이
        outerHeight
            -> 스크롤바 포함한 높이


브라우저 객체
window
    .alert
    .prompt
    .confirm
    .setInterval
    .setTimeout

    location
    history
    screen
    navigator

    document ** -> 웹페이지 출력해주는 문서
    - HTML 문서를 다루는 객체
    - HTML 요소(태그)를 다루는 메서드
    - 요소를 추가, 삭제, 변경 ...

    - 아이디로 선택(선택은 1개)
        document.getElementById("아이디");

    - 클래스명으로 선택(선택을 여러개)
        document.getElementsByClassName("클래스명");

    - 요소(태그명)으로 선택(선택을 여러개)
        document.getElementsByTagName("태그명");

    - name 속성으로 선택(선택을 여러개)
        document.getElementsByName("name 속성명");

    - css 선택자 선택
        document.querySelector("css 선택자");
        -> 선택 1(가장 먼저 매칭된 요소)

        document.querySelectorAll("css 선택자")
        -> 복수개 선택

브라우저
HTML(텍스트) -> 해석 -> HTML 요소를 자바스크립트가 인식할 수 있는 구조로 변환(document Object Model - DOM Tree)

- DOM Tree(document Object Model)
    -> HTML 위에서 아래방향으로 구조화

- DOM Tree 구조를 다 구성
-> 웹 브라우저 이벤트 발생
    - DOMContentLoaded - HTML 구성 완료(DOM Tree)
    - load - HTML태그에 있는 외부 리소스(css 파일, js 파일, 이미지, 비디오,  내부 iframe 내용물)

- 이벤트 -> 클릭, 마우스 움직이는 것, 마우스 클릭, 드래그, 스크롤, 키보드 키를 누르는 것 ...
- 바인딩
    - 속성명(on 이벤트 종류)
        -> click - onClick = "동작할 함수"

    - addEventListener

    이벤트
        - click

    마우스 관련 이벤트
       - click
       - mousedown
       - mousemobe
       - mouseup

    키보드 관련 이벤트
        - keyup -> 키를 눌렀다 뗄때 발생
        - keydown -> 키가 눌리고 있는 동안 계속 발생
        - keypress -> 키가 눌렸을때 1번 발생

    화면 통제 이벤트
        - scroll -> 스크롤 할 때 발생
        - resize -> 화면을 축소, 확대 할 때 발생

    
    window -> 하위 속성 -> on이벤트명 속성
        console.dir(window);