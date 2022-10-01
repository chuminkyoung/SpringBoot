package member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JoinService {
	
	// @Autowired	// 의존성 자동 주입
	private MemberDao memberDao;
	
	
	public void process(MemberDto member) {
		// process 메서드 내에서 memberDao를 반드시 써야 한다.
		// process 메서드에서는 memberDao를 의존한다.
		memberDao.register(member);
		
		// Map<String, MemberDto> members = memberDao.getMembers();
		// System.out.println(members);
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
