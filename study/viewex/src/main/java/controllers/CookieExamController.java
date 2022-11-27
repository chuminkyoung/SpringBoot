package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieExamController {
	@GetMapping("/ex01")
	public void exam(HttpServletResponse response) {	// 쿠키 등록
		Cookie cookie = new Cookie("key1", "value1");
		cookie.setMaxAge(60 * 60 * 24 * 7); // 쿠키 제거 시간 : 일주일 뒤 만료시간 1분 * 1시간 * 하루 * 1주일
		response.addCookie(cookie);	// 응답 헤더 : Set-Cookie : key1=value1 		// 쿠키 브라우저에 저장
	}
	
	@GetMapping("/ex02")
	public void exam2(HttpServletRequest request) {		// 쿠키 조회
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			System.out.printf("name=%s, value=%s%n", cookie.getName(), cookie.getValue());
		}
	}
	
	@GetMapping("/ex03")
	public void exam3(@CookieValue("key1") String name) {	// 스프링이 알아서 쿠키 주입
		System.out.println(name);
	}
}
