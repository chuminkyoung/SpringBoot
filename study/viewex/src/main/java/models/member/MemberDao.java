package models.member;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import controllers.members.JoinRequest;

@Component
public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Member> rowMapper = (rs, i) -> {
		
		Member member = new Member();
		member.setMemNo(rs.getLong("memNo"));
		member.setMemId(rs.getString("memId"));
		member.setMemPw(rs.getString("memPw"));
		member.setMemNm(rs.getString("memNm"));
		member.setEmail(rs.getString("email"));
		member.setMobile(rs.getString("mobile"));
		member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
		Timestamp modDt = rs.getTimestamp("modDt");
		if(modDt != null) {
			member.setModDt(modDt.toLocalDateTime());
		}

		return member;
	};
	
	/**
	 회원 DB 저장
	 * @param request
	 * @return
	 */
	public boolean register(Member request) {
		String sql = "INSERT INTO member (memId, memPw, memNm, email, mobile) " + 
					" VALUES (?, ?, ?, ?, ?)";
		
	
		// 010-1234-1234, 010 1234 1234, 010_1234_1234 -> 숫자변환-> 01012341234
		String mobile = "";
		String _mobile = request.getMobile();
		if(_mobile != null) {
			mobile = _mobile.replaceAll("\\D", "");	// 숫자 아닌 문자를 제거 -> 숫자만 남는다.
		}
	
		int affectedRows = jdbcTemplate.update(sql, 
			 									request.getMemId(), 
			 									request.getMemPw(),
			 									request.getMemNm(),
			 									request.getEmail(),
			 									mobile);
		return affectedRows > 0; //true -> DB 추가 성공
	}
	
	public Member get(String memId) {
		try {
			String sql = "SELECT * FROM member WHERE memId= ?";
			Member _member = jdbcTemplate.queryForObject(sql, rowMapper, memId);
			if(_member == null) {
				throw new RuntimeException("회원 없음!");
			}
			
			return _member;
		}catch (Exception e) {
			
			if (e instanceof RuntimeException) {
				throw e;
			}
			return null;
		}
	}
	
	public List<Member> gets(){
		List<Member> members = jdbcTemplate.query("SELECT * FROM member", rowMapper);
		
		return members;
	}
}

