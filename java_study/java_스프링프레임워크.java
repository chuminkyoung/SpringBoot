스프링 프레임워크(Framework) - 소프트웨어
- 프레임워크 - 표준화된 설계
- 애플리케이션 캐발에 필요한 여러가지 기능들을 표준화해서 설계한 틀







개발환경
    - STS
    - jar 
    - 메이븐(maven) - 자동 의존성 해결 설치, 빌드 툴, 테스트 ...
        - 환경 변수 설정 - mvn 명령어가 어디에서든 실행되도록 설정
        - apache maven 검색
            https://maven.apache.org/download.cgi
            -> Binary zip archive -> link 클릭 다운
            -> 압축풀어서 폴더에 보관만 하면 사용 가능

    JAVA_HOME

    mvn archetype:generate

    pom.xml
    - Project Object Manager - 메이븐 설정파일
                             - 의존성 자동 설치(라이브러리 자동 설치 -> 해당 라이브러리가 필요한 의존하는 라이브러리가 있으면 자동 처리)

    

spring-context
    repository.com -> spring-context 검색
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.23</version>
        </dependency>

    ** 스프링 컨테이너 -> 객체 관리
    ApplicationContext
    AnnnotationConfigApplicationContext





# 스프링 컨테이너 - 객체 (다양하게)관리 컨테이너
@Bean
1. 설정 클래스에 정의된 @Bean - 객체 자동 생성

# 스프링 DI (Dependency Injection)
- 의존성 주입(DI)
-> DTO 클래스 (Data Transfer Object) - 데이터 전달용
-> DAO 클래스 (Data Accecss Object) - 데이터 접속 객체
    - 데이터를 처리하는 객체(DB 처리)
-> Service 클래스 - 실 기능을 구현하는 클래스

의존성 주입?
// 특정 메서드에서 의존한다


2. 의존성 자동 주입
@Autowired
- 스프링 컨테이너 안에 관리되는 객체에서 찾아서 의존성을 자동 주입

    1) 멤버 변수
    2) 메서드 의존성 주입


# maven 사용방법
cmd -> 스프링파일 연결 cd: 파일위치 -> mvn archetype:generate

pom.xml

 

# 회원 가입
- DTO, DAO, Service 세가지 파일 필요





# 스프링
    - 스프링 컨테이너 -> 객체 관리
    - 다양한 방식으로 편리하게 객체를 관리

    BeanFactory 인터페이스
        - @Bean ... 객체를 찾아서 생성
        - getBean

    ApplicationContext 인터페이스
        - 응용 기능

    AnnotionConfigApplicationContext -> 애노테이션방식으로 설정을 하는 스프링 컨테이너


    스프링 컨테이너 안에 관리되는 객체 -> 설정 클래스 안에 정의 된 메서드를 -> 빈 객체
    @Configuration - 이 애노테이션이 있는 클래스 (빈 객체 - 설정 클래스) 
        - @Bean 정의한 메서드가 스프링 컨테이너 초기화시에 호출되면서 객체가 생성(스프링 컨테이너..)

    - 스프링 컨테이너 안에서 관리되는 객체는 반드시 스프링 컨테이너 안에 생성된 객체만 관리!!

    - 의존성 해결 
        - 스프링 컨테이너 안에 관리 객체 중에서 @Autowired로 정의된 객체 - 자동 주입(자동 객체 할당)


    @Autowired 
        - required:필수 -> default:true -> 스프링에서는 무조건 주입
                                        -> 빈객체를 못찾으면 오류 발생 (기본 동작)

                        @Autowired(required=false) -> 빈 객체가 없으면 주입 X

    빈 객체가 없는 경우 주입을 피하는 방법
    1) @Autowired(required=false)
        - 빈 객체가 없으면 정의된 메서드 호출 X

    2) @Nullable -> 빈 객체가 없으면 null을 주입
        - 빈 객체가 없으면 메서드를 호출하고 null을 주입

    3) Optional 클래스를 이용하는 방법




3. 컴포넌트 스캔
    - 빈 객체를 자동 검색 -> 빈으로 등록
    @ComponentScan(...검색할 범위(패키지) ...)

    검색 후 자동 등록
    @ComponentScan
    @Controller
    @Configuration
    @Service
    @Repository
    @Aspect

    - 자동 추가되는 빈 이름 -> 맨 앞 첫글자를 소문자로 한 클래스명
    예) MemberDao -> memberDao




4. 빈 라이프 사이클과 범위

    빈 객체 생성 -> 의존성 해걸 -> 초기화(사용자 정의 메서드 호출) -> 소멸(소멸 전 사용자 정의 메서드가 있으면 호출)

    1) 객체생성
    2) 의존성 해결
    3) 초기화
        - 사용자 정의 기능
        - InitializingBean 인터페이스
    4) 소멸
        - 사용 정의 기능
        - DisposableBean 인터페이스

InitializingBean, DisposableBean -> 직접 정의한 클래스에서만 사용이 가능

초기화, 소멸시 메서드 호출을 외부 라이브러리에서 해야 될 때?
데이터 베이스
Connection, Statement, ResultSet -> 사용 후에 자원해제

JDBC API

@Bean
    - initMethod - 초기화 단계에서 호출될 메서드
    - destroyMethod - 소멸전에 호출될 메서드


