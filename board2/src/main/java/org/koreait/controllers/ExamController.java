package org.koreait.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.koreait.entity.Member;
import org.koreait.models.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {
	
	@Autowired
	private MemberRepository repository;
	
	@GetMapping("/ex01")
	public void ex01() {
		Member member = new Member();
		member.setMemId("user01");
		member.setMemNm("사용자01");
		member.setMemPw("1234");
		member.setEmail("user01@test.org");
		member.setMobile("01000000000");
		
		Member newMember = repository.save(member);
		System.out.println(newMember);
		
		newMember.setMemNm("(수정)사용자01");
		newMember.setEmail("(수정)user01@test.org");
		
		newMember = repository.save(newMember);
		System.out.println(newMember);
		
		repository.delete(newMember);
		
	}
	
	@GetMapping("/ex02")
	public void ex02() {
		List<Member> members = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			Member member = new Member();
			member.setMemId("user" + i);
			member.setMemNm("사용자" + i);
			member.setMemPw("1234");
			member.setEmail("user" + i + "@test.org");
			member.setMobile("01000000000");
			members.add(member);
		}
		
		List<Member> newMembers = repository.saveAll(members);
		
		
		List<Member> findMembers = repository.findAll(Sort.by(Direction.DESC, "memNo"));	// 정렬

		System.out.println("------------ 전체 목록 조회 ------------");
		System.out.println(findMembers);
		
		System.out.println("------------ 회원번호 2번 조회 ------------");
		Member member = repository.findById(2L).orElse(null);
		System.out.println(member);
	}
	
	@GetMapping("/ex03")
	public void ex03() {
		Member user02 = repository.findMemberByMemId("user2");
		System.out.println(user02);
		
		LocalDateTime sDate = LocalDateTime.now().minusDays(1); 	// 하루전
		LocalDateTime eDate = LocalDateTime.now().plusDays(1);		// 하루뒤
		List<Member> members = repository.findByRegDtBetweenOrderByRegDtDesc(sDate, eDate);
		System.out.println(members);
	}
	
	@GetMapping("/ex04")
	public void ex04() {
		List<Member> members = repository.findByMemNmContaining("사용자");
		System.out.println(members);
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		List<Member> members = repository.findByKeyword("2");
		System.out.println(members);
	}
}
