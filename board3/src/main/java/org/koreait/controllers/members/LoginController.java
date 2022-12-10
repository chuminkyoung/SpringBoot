package org.koreait.controllers.members;

import javax.validation.Valid;

import org.koreait.service.members.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@GetMapping
	public String form(Model model) {
		
		LoginRequest loginRequest = new LoginRequest();
		model.addAttribute("loginRequest", loginRequest);
		
		return "member/login";
	}
	
	@PostMapping
	public String process(@Valid LoginRequest loginRequest, Errors errors) {
		
		service.process(loginRequest, errors);
		
		if(errors.hasErrors()) {
			return "member/login";
		}
		
		return null;
	}
}
