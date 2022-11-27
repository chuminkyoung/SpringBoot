package config;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import member.JoinService;
import member.ListService;
import member.MemberDao;

@Configuration	// 중요
public class AppCtx {
	
	@Bean	// 중요
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public JoinService joinService() {
		JoinService joinService = new JoinService();	// 의존성 해결
		
		return joinService;
	}
	
	@Bean
	public ListService listService() {
		
		return new ListService();
	}
	
	
	@Bean
	public DateTimeFormatter dateTimeFormatter() {
		return DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
	}
	
}


