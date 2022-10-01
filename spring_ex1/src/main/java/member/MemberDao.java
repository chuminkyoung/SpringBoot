package member;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	// 회원 가입 데이터 담기
	private Map<String, MemberDto> members = new HashMap<>();
	
	// 회원 가입
	public void register(MemberDto member) {
		members.put(member.getMemId(),member);
	}
	
	// 회원 목록 조회
	public Map<String,MemberDto> getMembers(){
		return members;
	}
}
