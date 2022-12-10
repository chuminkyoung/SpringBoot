package org.koreait.service.members;

import org.koreait.controllers.members.LoginRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class LoginService {
	public void process(LoginRequest loginRequest, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
	}
}
