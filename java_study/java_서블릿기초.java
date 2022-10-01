서블릿 기초

서블릿(Serviet) - 자바 기반의 웹 기술

jar -> java -jar 다운로드 받은 파일명

1. tomcat 9
    tomcat 9 download
    https://tomcat.apache.org/download-90.cgi
    core : 64-bit

    프로젝트 생성시
    -> file - new - other - Web - Dynamic Web Project


2. java ee8 - 즐겨찾기 -> 필요할때마다 찾아서 참고
    https://javaee.github.io/javaee-spec/javadocs/overview-summary.html




tar -xvf ~/Downloads/apache-[tab] 압축을 풀 경우



서블릿
java.servlet.*
javax.servlet.http.*

javax.servlet.http
javax.servlet.클래스

서블릿 <-- HttpServlet 클래스만 상속
        - 요청 메서드별로 메서드 정의

        - 요청, 응답


        요청 메서드(doGet, doPost, doPut ...)
            - HttpServletRequest    (요청 - 브라우저)
                - 요청한 쪽의 정보, 데이터, 요청 관련 메서드
                - String getParameter("HTML 요소의 name값")

            - HttpServletRespponse  (응답 - 서버)
                - 응답에 대한 정보, 응답 관련 메서드
                    - HttpServletResponse
                        - PrintWriter getWriter -> 출력 객체 반환


        서블릿 클래스 -> 요청 경로와 매칭(매핑)
            webapp/WEB-INF/web.xml - 웹 설정(서블릿 설정이 포함)