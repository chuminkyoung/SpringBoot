package main;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.config.AppCtx;

public class Ex01 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		/**
		String sql = "INSERT INTO member (memNo, memId, memNm, email, mobile) " +
							" VALUES (?, ?, ?, ?, ?)"; 
		int affectedRows = jdbcTemplate.update(sql, 3, "user03", "사용자03", "user03@test.org", "01000000000");
		System.out.printf("반영된 레코드 수 : %d%n", affectedRows);
		**/
		
		String sql = "SELECT * FROM member";

		List<Member> members = jdbcTemplate.query(sql, (rs, rowNum) -> {
				Member member = new Member();
				member.setMemNo(rs.getLong("memNo"));
				member.setMemId(rs.getString("memId"));
				member.setMemNm(rs.getString("memNm"));
				member.setEmail(rs.getString("email"));
				member.setMobile(rs.getString("mobile"));
				member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
				
				Timestamp modDt = rs.getTimestamp("modDt");
				if(modDt != null) {
					member.setModDt(modDt.toLocalDateTime());
				}
				
				return member;
			}
		);
		
		System.out.println(members);
		
		ctx.close();
	}
}
