package controllers.members;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import services.member.JoinService;

@Controller
@RequestMapping("/member")	// 공통적인 부분 정해주기
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	
	@GetMapping("/join")	// 브라우저 찾기	// /member/join
	public String join(Model model) {
		
		JoinRequest joinRequest = new JoinRequest();
		model.addAttribute("joinRequest", joinRequest);
		
		
		return "member/join";
	}
	
	
	
	
	@PostMapping("/join")	// 데이터 작성	// /member/join_ps
	// @RequestMapping("/member/join_ps")	
	public String joinPs(@Valid JoinRequest joinRequest, Errors errors) {	// Errors 비밀번호 검증

		new JoinValidator().validate(joinRequest,  errors);
		
		if(errors.hasErrors()) {	// 검증 실패가 1개 이상 있다
			
			return "member/join";
		}
		
		// 검증 성공 -> 가입 처리
		joinService.process(joinRequest);
		
		return "redirect:/member/login";
	}
	
	
}
