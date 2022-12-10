package org.koreait.service.members;

import org.koreait.controllers.members.JoinRequest;
import org.koreait.entity.Member;
import org.koreait.repository.MemberRepository;
import org.mindrot.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.mindrot.bcrypt.BCrypt;


@Service
public class JoinService {
	
	@Autowired
	private MemberRepository repo;
	
	public void process(JoinRequest joinRequest) {
		
		String hash = BCrypt.hashpw(joinRequest.getMemPw(), BCrypt.gensalt(12));
		
		Member member = new Member();
		member.setMemId(joinRequest.getMemId());
		member.setMemNm(joinRequest.getMemNm());
		member.setEmail(joinRequest.getEmail());
		member.setMobile(joinRequest.getMobile());
		member.setMemPw(joinRequest.getMobile());
		member.setMemPw(hash);
		
		repo.save(member);
	}
}
