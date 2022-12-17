package org.koreait.controllers.members;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.koreait.service.members.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@GetMapping
	public String form(Model model, @CookieValue(value="savedMemId", required=false) String savedMemId) {
		
		LoginRequest loginRequest = new LoginRequest();
		if(savedMemId != null) {
			loginRequest.setMemId(savedMemId);
			loginRequest.setSavedMemId(true);
		}
		
		model.addAttribute("loginRequest", loginRequest);
		
		return "member/login";
	}
	
	@PostMapping
	public String process(@Valid LoginRequest loginRequest, Errors errors, HttpServletResponse response) {
		
		service.process(loginRequest, errors);
		
		if(errors.hasErrors()) {
			return "member/login";
		}
		
		
		/** 아이디 저장하기 처리 S*/
		Cookie cookie = new Cookie("savedMemId", loginRequest.getMemId());	// 암호화 처리 안해씀..! 원래는 꼭 해야함!
		if(loginRequest.isSavedMemId()) {
			cookie.setMaxAge(60*60*24*365);	// 1년간 아이디 저장
		}else {
			cookie.setMaxAge(0);	// 쿠키 제거
		}
		response.addCookie(cookie);
		/** 아이디 저장하기 처리 E*/
		
		
		return "redirect:/";	// 로그인 성공 -> 메인페이지로 이동
	}
}
