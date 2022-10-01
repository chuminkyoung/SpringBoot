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




메이븐 사용방법


스프링 dI


