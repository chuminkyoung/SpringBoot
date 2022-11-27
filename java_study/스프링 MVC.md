# 스프링 웹 MVC
spring-webmvc
servlet-api
servlet.jsp-api


<scope>provided</scope>

<scop
    - compile
    - provided  -> 배포시에는 포함 x
    - test 

HandlerMapping -> 요청 URL -> 해당하는 Bean 컨트롤러 객체
                                - @Controller
                                - Controller 인터페이스
                                - HttpRequestHandler 인터페이스
-> 요청 처리 -> HandlerAdapter
                -> 동일한 방식으로 처리
                -> ModelAndView

--> ViewResolver -> 템플릿 찾고 -> view 객체
--> View -> 응답, 출력


Map<K, V>



===========================================================

<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.23</version>
</dependency>

<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api -->
<dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>javax.servlet.jsp-api</artifactId>
    <version>2.3.3</version>
    <scope>provided</scope>
</dependency>

===========================================================



# MVC란?

M - Model
  - 요청에 따른 비지니스 로직
  - DTO(Data Transfer Object) : 데이터 전달
  - DAO(Data Access Object) : 데이터에 접근
  - Service : DTO, DAO, 검증로직, 기타로직
    -> 하나의 기능 구현

V - View
  - 응답

C - Controll
  - 요청, 응담의 창구




# 스프링 웹MVC와 타임리프 연동 설정

servlet-api
servlet-jsp.api     -> javax.servlet-jsp-api 검색
spring-webmvc

thymeleaf
thymeleaf-layout
thymeleaf- jsr310
    -> https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-java8time
slf4j


web.xml
    servlet
    filter



## 추가 =========================================================================
    <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
	<dependency>
	    <groupId>javax.servlet</groupId>
	    <artifactId>javax.servlet-api</artifactId>
	    <version>4.0.1</version>
	    <scope>provided</scope>
	</dependency>
	
  	<!-- https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api -->
	<dependency>
	    <groupId>javax.servlet.jsp</groupId>
	    <artifactId>javax.servlet.jsp-api</artifactId>
	    <version>2.3.3</version>
	    <scope>provided</scope>
	</dependency>
	

  	<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-webmvc</artifactId>
	    <version>5.3.23</version>
	</dependency>

	<!-- https://mvnrepository.com/artifact/org.thymeleaf/thymeleaf-spring5 -->
	<dependency>
	    <groupId>org.thymeleaf</groupId>
	    <artifactId>thymeleaf-spring5</artifactId>
	    <version>3.0.15.RELEASE</version>
	</dependency>
	
	<!-- https://mvnrepository.com/artifact/nz.net.ultraq.thymeleaf/thymeleaf-layout-dialect -->
	<dependency>
	    <groupId>nz.net.ultraq.thymeleaf</groupId>
	    <artifactId>thymeleaf-layout-dialect</artifactId>
	    <version>3.1.0</version>
	</dependency>
	
	<!-- https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-java8time -->
	<dependency>
	    <groupId>org.thymeleaf.extras</groupId>
	    <artifactId>thymeleaf-extras-java8time</artifactId>
	    <version>3.0.4.RELEASE</version>
	</dependency>
	
	<!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
	<dependency>
	    <groupId>org.slf4j</groupId>
	    <artifactId>slf4j-api</artifactId>
	    <version>2.0.3</version>
	</dependency>
	
	<!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
	<dependency>
	    <groupId>ch.qos.logback</groupId>
	    <artifactId>logback-classic</artifactId>
	    <version>1.4.4</version>
	</dependency>
## 추가 end =========================================================================


빈 -> 자동 검색

@ComponentScan

- 자동 빈객체
@Component
@Controller
@Service
@Configration
@Repostiory
@Aspect




# 타임리프(Thymeleaf) 기본 문법

타임리프 - natural template
    - 디자이너, 퍼블리셔와 협업

JSP


식
속성값 : 
변수식 : ${속성값}
메세지 식 : #{코드}
링크 식 : @{링크} : 컨텍스트 Path
선택 변수식 : *{속성명} : th:object="${객체}"

th:text - 태그 안쪽의 내용을 치환
        - 텍스트만 출력 (html 태그는 인식 x)

th:utext - HTML 태그 까지 출력

- 상단 태그에 th:object="${member}" 추가해주면 th:text="*{내용}" 을 th:text="${member.memNm}" 대신 사용가능




<a href -> th:href
<img src -> th:src
<form action=".." th:action


브라우저
요청 ----> 서버 ----> 응답
    - 방식 -
    - GET : 조회
        브라우저에 주소를 입력하는 방식

        https://search.naver.com/search.naver
            ?query=지진 -> 검색을 위한 부가 데이터
                        -> 질의(Query) -> 쿼리스트링
            
            ?키=값&키=값
        
    - POST  : 데이터 작성



# 조건문
    th:if="${조건식}" : 조건식이 참일때 노출
    th:unless="${조건식}" : 조건식이 거짓일때 노출

# 반복문
    th:each="item : ${items}"   
    th:each="item, status : ${items}"

    status : -> 반복에 대한 상태 값
             -> status.index -> 반복 순서(0부터 시작)
             -> status.count -> 반복 순서(1부터 시작)
             -> status.even -> 반복이 짝수번째 인지?
             -> status.odd -> 반복이 홀수번째 인지?

# 식 객체
#strings
#numbers
#lists
#arrays
#dates
#calendars
#temporals


식 객체에서 없는 기능 -> 직접 만들어서 스프링 Bean으로 등록
// ${@빈이름.메서드(...)}


태그 없이 식을 사용
<th:block ...> </th:blok>

JSP 내장객체
    - PageContext





# 요청 매핑
    요청(request) - 브라우저 -> 요청 URL -> 서버 경로 접근

    스프링 웹 MVC 서버 -> 요청 URL -> 처리할 수 있는 컨트롤러 빈
    (HandlerMapping)
    -> 실행

    - 요청 방식에 따라서 애노테이션

    요청 전문
        - 요청 헤더(header)
            - 요청하는 쪽에 대한 정보
            - 브라우저 정보, 언어정보, ip ...
            - 요청본문의 형식
            - 요청 방식(Method)
                - GET : 조회
                    - 주소창에 주소를 입력하여 조회
                        ?키=값&키=값
                    
                - POST : 데이터 작성
                    
                    Content-Type
                        - application/x-www-form-urlencoded
                            키=값&키=값
                        - application/json
                        -> 데이터 -> 요청 본문

        - 요청 본문(body)
            - 전송할 데이터

    응답 전문
        - 응답 헤더(header)
            - 응답할 데이터 형식(Content-Type)
            - 응답 코드(status code - 200 -> 정상, 300, 400, 500 -> 비정상)
            ...
            - 브라우저 행위
                - Location: "주소" -> 브라우저는 페이지 이동
                - Content-Disposition -> 브라우저는 다운로드...

        - 응답 본문(body)
            - 응답 형식에 따르는 출려 데이터
                예) text/html -> 출력은 HTML 출력

    
    매핑 -> 찾아주는 것

    @GetMapping - GET 방식으로 요청했을때

    @PostMapping - POST 방식으로 요청했을때
        - @PutMapping
        - @PatchMapping

    @RequestMapping - 모든 요청 방식에 해당하는


# 리다이렉트
    - URL 이동 : 응답 헤더 Location: 주소

    return "redirect:주소";


# 커맨드 객체
    - 요청 데이터
        @RequestParam
        - 하나의 파라미터를 매핑

    - ** 요청 데이터 자동 매핑 ** 중요!!
        
        JoinRequest
            -> el 식 -> joinRequest -> 템플릿

        

# 모델
    Model 
        - addAttribute
        - getAttribute
    
    -> 출력 템플릿 el 변수 ${변수명}

요청 메서드에 자동 주입되는 객체
    - Modele model
    - 커맨드 객체
    - HttpServletRequest
    - HttpServletResponse
    - HttpSession
    - Errors - 순서o


# 폼 태그(Thymeleaf로 진행)




==================================================================================




# 메시지
1. 문구 관리
    1) 동일 적용 문구 -> 한군데서 관리 -> 변경 -> 전체 반영
        ex) 아이디 -> 사용자 ID

    2) 다국어(Locale)
        member_ko.properties
        member_en.properties

    식
        - 변수 식: ${변수}
        - URL 식: @{URL}
        - 선택객체 식: *{객체 속성명}
        - 메세지 식: #{메세지 코드}


# 커맨드 객체 검증
    - Interface Validator
        - supports
            - 검증 커맨드 객체 한정
        - validate
            - 커맨드객체 검증

    - Errors
        - rejectValue(String field, String messageCode);
            - 요청 파라미터 이름 - 메세지 코드
            - 특정 파라미터의 오류

        - rejectValue(String field, String messageCode, String defaultMessage);
            - messageCode로 등록된 문구 X -> 기본메세지(defaultMessage)

        - reject(String messageCode)
            - 커맨드 객체 자체의 오류

        - reject(String messageCode, String defaultMessage)

    - hasErrors()
        - 한개 이상의 reject, rejectValue 호출 true

    메세지
        - 오류코드.필드명
        - 오류코드.커맨드객체명.필드명
        - 오류코드.커맨드객체.자료형.필드명

    양식 데이터 검증
        - 가장 많은 빈도수 -> 필수 항목 체크

            ValidationUtils
                - rejectIfEmpty(Errors errors, String code ...)
                    : 항목이 null 체크

                - rejectIfEmptyOrWhitespace(Errors errors, String code ...)
                    : 항목이 null 체크, 공백을 포함한 빈 데이터

    errors.rejectValue -> ${#fields.errors("필드명")}
    errors.reject -> ${#fields.errors('global')}
                  -> ${#fields.globalErrors()}
    
    Bean Valiation API -> javax.validation -> 정의
    hibernate-validator -> 구현재



# 쿠키
    Cookie
        - 개인화된 데이터 (사용하는 브라우저별 구분되는 데이터)
            -> 로그인
        - 저장되는 위치 : 웹브라우저

    서버 응답 헤더
        Set-Cookie: 키=값;키=값
        -> 브라우저에게 쿠키 값을 저장해라

    서버가 응답할 때 응답헤더 Set-Cookie: 키=값;...
    -> 브라우저가 브라우저의 저장소인 쿠키 -> 값 저장
    
    서버에서 브라우저에 있는 쿠키를 접근 할 때는?
    -> 브라우저가 가지고 있는 쿠키 서버로 보내야(요청) 한다.
    -> 브라우저에서 요청시 요청 헤더에 쿠키 정보가 서버로 전송


    HttpServletRequest
        - getCookes: 쿠키 조회 

    HttpServletResponse
        - addCookie: 쿠키 등록
            문서 검색 참조 - https://javaee.github.io/javaee-spec/javadocs/index.html?overview-summary.html

        Cookie
            - setMaxAge
                - 만료시간을 0으로 설정하면 쿠키 삭제
                - addCookie



# 세션
    개인화된 데이터 -> 서버 저장
    HttpSession
        - setAttribute("키", "값") : 추가, 변경
        - getAttribute("키") : 조회
        - removeAttribute("키") : 삭제

        - invalidate() : 세션 데이터 비우기

        // 개인화 된 아이디
        JEESSIONID: 브라우저별 구분 키값
            -> 키값을 브라우저가 서버에 요청 헤더를 통해 전송(Cookie)
            -> 서버는 이 키값을 이용해서 서버에 저장된 개인화 된 세션 데이터를 찾아서 복구

        spring-jdbc
        tomcat-jdbc
        mysql-connector-java

        member table
            momNo - 회원넘버 PK( 기본키, 자동 증감번호 )
            memId - 아이디 : Unique key(중복x)
            memPw - 비밀번호
            memNm - 회원명
            email - 이메일
            mobile - 휴대전화번호
            regDt - 가입일자
            modDt - 수정일자

        M - 비지니스 로징
            - DAO(Data Access Object) : DB 접근 추가, 삭제, ...
            - Dto(Data Transfer Object) : 데이터 전달
            - Service : 실제 기능 구현 부분
        V 
        C - Controller

        JdbcTemplate
            - update : 데이터 변화(INSERT, UPDATE, DELETE)
            - query : 데이터 조회(SELECT)

        웹MVC -> 스프링 컨테이니너 <-- 서블릿 핵심 객체
        HttpSession


# 인터셉터
    - 공통 부분
    - 컨트롤러 실행 전 -> preHandle
        - 반환값이 false : 컨트롤러 실행 x

    - 컨트롤러 실행 후(출력 전) -> postHandle
        - 반환값이 false : 출럭 x

    - 출력 완료 후 -> afterCompletion

    HandlerInterceptor

        - 예) 회원 전용 페이지, 접근 제한
            /mypage
            
        - 예) 관리자 페이지, 관리자로만 접근제한


# @PathVariable을 이용한 경로 변수 처리



# 날짜값 변환
-> LocalDteTime, LocalDate -> temporal
Date, Calendar
@DateTimeFormat(pattern="yyyy-MM-dd")
-> 형식 일치하지 않으면
errors.rejectValue
-> typeMismatch



# 컨트롤러 예외 처리 ** 초기 설정 구성
@ExceptionHandler(예외 클래스의 class)

-> 공통적으로 특정 패키지에 모든 컨트롤러에 적용
@ControllerAdvice


# 스프링 부트 설정


# 스프링 파일 업로드(MultipartFile)

< form ... method="post" enctype="multipart/form-data" > 

< /form >

Request Header
Content-Type : application/x-www-form-urlencoded

Request Body
키=값&키=값


multipart // -> 파일을 나눠서 전송하는것

---- form 양식 데이터 part ----
키=값&키=값

---- form 파일 바이트 데이터 part ----
파일 바이트 데이터


# 프로필과 프로퍼티 파일

@Value


# 아마존 웹서비스 - 프리티어
EC2


# 간단한 갤러리 게시판 만들기
@Controller -> 반환값 -> 출력 템플릿 경로(html)

@RestController
JSON

jackson


- 서버 업로드 되는 파일 - 중복이 되지 않는 파일명으로 변환

- 다운로드시 DB 기록을 보고 -> 원래 업도드한 파일명으로 다운로드

fileInfo
    long id - 파일 등록 번호 - 서버에 올라가는 파일명
    String gid - 그룹 ID - 파일을 그룹으로 묶어서 관리
    String fileName - 원본 파일 이름
    String fileType - 파일 종류
    boolean success - 게시글 작성과 같은 그룹 작업
                    - 완료 여부

    게시글 하나 <-- 이미지 여러개, 첨부파일 여러개


파일 DB -> 기록 -> id(증감번호) -> 서버에 업로드

다운로드 -> 파일 정보 DB 조회 -> id 실 파일을 찾고 -> 다운로드시에는 원본 파일 명으로 다운로드 처리


# MultipartFile

enctype='multipart/form-data'

Content-Type : application/x-www-form-urlencoded

요청 body(본문)
키=값&키=값

multipart -> 전송 부분의 파트를 나눠서

---- 일반 양식 데이터 part ----
키=값&키=값

---- 파일데이터 part ----
...



응답
응답 헤더(header)
    - 응답 본문의 타입 -
        Content-Type : ...
    - 응답 코드
    - 브라우저의 동작 통제
        Location: 주소
        Refresh: ...
        Set-Cookie: 키=값

        Content-Disposition

응답 본문(body)
    - 서버 응답 데이터(text/html),
    - application/json
    - application/octet-stream




# 처음 세팅

local



