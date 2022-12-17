package org.koreait.service.members;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.koreait.controllers.members.LoginRequest;
import org.koreait.entity.Member;
import org.koreait.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import org.mindrot.bcrypt.BCrypt;

@Service
public class LoginService {
	
	@Autowired
	private MemberRepository repository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private HttpSession session;
	
	public void process(LoginRequest loginRequest, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		/**
		 * 1. 아이디로 조회 -> 회원이 있는지?
		 * 2. 회원이 있으면? 비번 체크
		 * 3. 로그인 처리
		 */
		
		try {
			Member member = repository.findByMemId(loginRequest.getMemId());
			if(member == null) {
				throw new RuntimeException("등록된 회원이 아닙니다.");
			}
			
			boolean matched = BCrypt.checkpw(loginRequest.getMemPw(), member.getMemPw());
			if(!matched) {	// 비번이 일치하지 않는 경ㅇ
				throw new RuntimeException("비밀번호가 일치하지 않습니다.");
			}
			
			em.detach(member);	// 영속성 제거
			
			session.setAttribute("member", member);
			
			
		}catch(RuntimeException e) {
			errors.reject("login.error", e.getMessage());
		}
	}
}
