package main;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx2;
import member.JoinService;
import member.ListService;
import member.MemberDto;

public class Ex03 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);
		
		// 회원가입
		// JoinService joinService = ctx.getBean("joinService", JoinService.class);
		JoinService joinService = ctx.getBean(JoinService.class);
		MemberDto memer = new MemberDto("user01", "123456", "사용자01", LocalDateTime.now());
		joinService.process(memer);
		
		// 회원 목록 출력
		// ListService listService = ctx.getBean("listService", ListService.class);
		ListService listService = ctx.getBean(ListService.class);
		listService.listing();
		
		ctx.close();

	}

}
