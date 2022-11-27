스프링 컨테이너
    - (다양한 방식)객체 관리
    
    라이프 사이클 : 스프링 컨테이너 안에서 객체가 만들어지고 사용되고 소멸되는 과정
    1. 객체 생성
        - 설정 클래스 안에 정의된 설정을 참고해서 객체 생성
            1) @Bean 애노테이션이 붙어 있는 객체 생성 메서드
                - 빈 이름 -> 메서드 명

            2) @ComponentScan에 정의되어 있는 범위(패키지)있는 클래스를 자동 검색 -> 객체 생성
                - 검색해서 자동 등록하는 클래스는 다음과 같은 애노테이션이 붙어 있다.
                    @Component
                    @Controller
                    @Configuration
                    @Service
                    @Repository
                    @Aspect

                    - 빈 이름 - 앞 첫글자를 소문자로 한 클래스명

    2. 의존성 해결
        - 의존성? -> 다른 메서드에서 특정 객체를 필요할때 -> 의존한다
        - 의존성 주입 -> 자동 처리
                     -> 필요한(의존하는) 객체 스프링 컨테이너 안에서 검색해서 있으면 그 객체를 대입(생성 X, 대입 O)
                     -> 생성이 아닌 이유는 객체 생성 단계에서 이미 만들어 져 있기 때문(어디에서든 주입하든 같은 객체!!)

        @Autowired
            - 적용 범위 : 멤버 변수, 메서드 매개변수
            - 기본 동작 : 스프링 컨테이너 안에 빈 객체가 없어도 주입 -> 없으면 NullPointException 발생
                            - required:true 기본
            
            - 빈 객체가 없는 경우 대응 할 수 있는 방법
                - required:false
                    - 빈 객체가 없으면 메서드 호출 X

                - @Nullable : 빈 객체가 없으면 null값을 주입
                    - 빈 객체가 없어도 메서드 호출, 다만 null을 의존하는 객체에 주입

                - Optional 클래스
                    - 빈 객체가 있으면 내부에 정의되어 있는 의존하는 객체에 주입
                    - 없으면 Optional 클래스 자체 메서드를 가지고 통제

    3. 초기화
        - 빈 객체에 초기화와 관련된 메서드가 정의되어 있으면 호출 실행
        - InitializingBean 인터페이스를 구현한 클래스 메서드

    4. 소멸
        - 스프링 컨테이너 객체 - close() 호출 했을때
        - 소멸 전에 호출되어야 할 메서드가 빈 객체에 정의되어 있으면 호출 실행
        - DisposableBean 인터페이스를 구현한 클래스의 메서드
        - 객체를 메모리에서 해제

        참고)
        외부 라이브러리는 InitializingBean, DisposableBean을 구현 X(원본 소스를 수정 X)
        @Bean
            - initMethod - 초기화시에 호출될 메서드 정의
            - destroyMethod - 소멸전에 호출될 메서드 정의

            @Bean(initMethod="init",destroyMethod="close")
            


// 1. 객체 생성 -> 2. 의존성 해결 -> 3. 초기화
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

Message ms = ctx.getBean(Message.class);	// 객체 생성 X, 객체를 스프링 컨테이너 안에서 조회 -> 가져오는 기능
ms.send();

ctx.close(); 	// 4. 소멸 (소멸 전에 사용자 정의 메서드 호출)





    
## 파일생성 -> // pom.xml 들어있는 파일 생성 방법
cmd -> c:폴더 경로 -> mvn archetype:generate -> Choose a number or apply filter 뜨면 -> 그룹아이디 : org.koreait -> 파일명 -> 엔터 엔터 엔터 완료!

-> 만든 파일은 스프링 부트에서 import 로 파일 불러옴

file -> import -> maven -> Existing Maven Projects (두번째) -> 만든 파일명 불러오기

-> pom.xml 에서 버전 수정 파일도 우클릭 맨 아래꺼로 클릭해서 버전 수정 해주기




## 파일 셋팅

https://mvnrepository.com/
검색 -> spring-context -> 최신 버전

    -> pom.xml 파일에서 <dependencies> 안에 아래 내용 붙여넣기
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.23</version>
        </dependency>


        - spring-aop - AOP API(스펙)
        - aspectJweaver


검색 -> aspectjweaver 검색 -> 가장 최신 버전 클릭 후 복사 -> 위 붙여넣은 내용 바로 아래에 붙여넣기
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.9.1</version>
            // <scope>runtime</scope> -> 제거
        </dependency>