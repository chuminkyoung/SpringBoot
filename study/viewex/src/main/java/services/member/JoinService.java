package services.member;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controllers.members.JoinRequest;
import models.member.Member;
import models.member.MemberDao;

import org.mindrot.bcrypt.BCrypt;


@Service
public class JoinService {
	
	
	@Autowired
	private MemberDao memberDao;
	
	public void process(JoinRequest joinRequest) {
		
		String hash = BCrypt.hashpw(joinRequest.getMemPw(), BCrypt.gensalt(12));
		Member member = new Member();
		member.setMemId(joinRequest.getMemId());
		member.setMemPw(hash);
		member.setMemNm(joinRequest.getMemNm());
		member.setEmail(joinRequest.getEmail());
		member.setMobile(joinRequest.getMobile());
		
		boolean result = memberDao.register(member);
		if(!result) {	// 가입 실패!
			throw new RuntimeException("회원 가입 실패하였습니다.");
		}
	}
}
