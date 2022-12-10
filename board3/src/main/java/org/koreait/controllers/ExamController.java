package org.koreait.controllers;

import java.util.ArrayList;
import java.util.List;

import org.koreait.entity.BoardData;
import org.koreait.entity.Member;
import org.koreait.entity.QBoardData;
import org.koreait.entity.QMember;
import org.koreait.repository.BoardDataRepository;
import org.koreait.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;

@RestController
public class ExamController {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardDataRepository boardDataRepo;
	
	@GetMapping("/ex01")
	public void Ex01() {	// 유저 생성
		Member member = new Member();
		member.setMemId("user01");
		member.setMemNm("사용자01");
		member.setMemPw("123456");
		member.setEmail("user01@test.org");
		member.setMobile("01000000000");
		
		member = memberRepo.save(member);
		System.out.println(member);
	}
	
	@GetMapping("/ex02")
	public void ex02() {	// 조회
		Member member = memberRepo.findById(1L).orElse(null);
		System.out.println(member);
	}
	
	@GetMapping("/ex03")
	public void ex03() {	// 아이디 조회
		Member member = memberRepo.findByMemId("user01");
		System.out.println(member);
	}
	
	@GetMapping("/ex04")
	public void ex04() {	// 게시글 데이터

		BoardData boardData = new BoardData();
		boardData.setSubject("제목");
		boardData.setContents("내용!");
		boardData.setPoster("작성자!");
		
		Member member = memberRepo.findByMemId("user01");
		boardData.setMember(member);
		
		boardDataRepo.save(boardData);
	}
	
	@GetMapping("/ex05")
	public void ex05() {	// 게시글 번호 조회
		BoardData data = boardDataRepo.findById(5L).orElse(null);
		System.out.println(data);
		Member member = data.getMember();
		System.out.println(member.getMemId());
	}
	
	@GetMapping("/ex06")
	public void ex06() {	// 회원마다 가지고 있는 게시글
		Member member = memberRepo.findByMemId("user01");
		List<BoardData> boardData = member.getBoardData();
		System.out.println(boardData);
	}
	
	@GetMapping("/ex07")
	public void ex07() {
		QMember member = QMember.member;
		
		BooleanBuilder booleanBuilder = new BooleanBuilder(); // and, or
		booleanBuilder.and(member.memId.eq("user01"));
		booleanBuilder.and(member.email.contains("user01"));
		
		List<Member> mem = (List<Member>)memberRepo.findAll(booleanBuilder);
		System.out.println(mem);
	}

	
	@GetMapping("/ex08")
	public void ex08() {
		QBoardData boardData = QBoardData.boardData;
		
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(boardData.member.memId.eq("user01"));
		
		List<BoardData> data = (List<BoardData>)boardDataRepo.findAll(booleanBuilder);

		
	}
	
	@GetMapping("/ex09")
	public void ex09() {	// 게시글 추가
		
		Member member = memberRepo.findByMemId("user01");
		List<BoardData> datas = new ArrayList<>();
		for(int i = 0; i <= 100; i++) {
			BoardData data = new BoardData();
			data.setSubject("제목" + i);
			data.setContents("내용" + i);
			data.setPoster("작성자" + i);
			data.setMember(member);
			datas.add(data);
		}
		
		boardDataRepo.saveAll(datas);
	}
	
	@GetMapping("/ex10")
	public void ex10() {	// 페이지 조회
		// BooleanBuilder booleanBuilder = new BooleanBuilder();
		
		Pageable pageable = PageRequest.of(0, 10);
		List<Order> orders = new ArrayList<>();
		orders.add(Order.desc("id"));
		orders.add(Order.asc("poster"));
		List<BoardData> list = boardDataRepo.findAll(Sort.by(orders));
		// List<BoardData> list = boardDataRepo.findAll(Sort.by(Direction.DESC, "id"));	// 아이디 순서로 내림차순
		
		// List<BoardData> list = page.getContent();
		
		System.out.println("게시글 수: " + list.size());
		//System.out.println(list);
	}
	
	@GetMapping("/ex11")
	public void ex11() {
		BooleanBuilder booleanBuilder = new BooleanBuilder();	// Predicate
		QBoardData boardData = QBoardData.boardData;
		QMember member = boardData.member;
		
		booleanBuilder.and(boardData.id.goe(10L))	// WHERE id >= 10 AND id <= 30 AND member.memId LIKE ...
					  .and(boardData.id.loe(100L))
					  .and(member.memId.contains("user"));
		
		// List<BoardData> list = (List<BoardData>)boardDataRepo.findAll(booleanBuilder);
		// System.out.println(list);
		
		// 페이징
		Pageable pageable = PageRequest.of(0, 10, Sort.by(Direction.DESC,"id"));	// 페이지 별 0~10번	 	// 아이디별 내림차순
		Page<BoardData> page = boardDataRepo.findAll(booleanBuilder, pageable);
		List<BoardData> list = page.getContent();
		System.out.println(list);
	}
	
//    각 엔티티의 멤버 변수 -> 객체
//    .eq ==
//    .lt <
//    .loe <=
//    .gt >
//    .goe >=
//    .like
//    .contains -> LIKE '%키워드%'
//    .endWith -> LIKE '%키워드'
//    .startWith -> LIKE '키워드%'
//    .in(Collection ...) 속성명 IN (....)
	
	
	@GetMapping("/ex12")
	public void ex12() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by(Order.desc("id")));		// 오름차순
		List<BoardData> list = boardDataRepo.findBySubjectContaining("제목", pageable);
		System.out.println(list);
	}
	
}
