package org.koreait.controllers;

import java.util.ArrayList;
import java.util.List;

import org.koreait.entity.BoardData;
import org.koreait.entity.Member;
import org.koreait.models.board.BoardDataRepository;
import org.koreait.models.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exam2Controller {
	
	@Autowired
	private MemberRepository repository;
	
	@Autowired
	private BoardDataRepository boardDataRepository;
	
	@GetMapping("/ex06")
	public void ex06() {
		// 1명의 회원이 여러개 게시글
		
		Member member = new Member();
		member.setMemId("user01");
		member.setMemNm("사용자01");
		member.setMemPw("1234");
		member.setEmail("user01@test.org");
		member.setMobile("01000000000");
		
		member = repository.save(member);
		
		List<BoardData> boardDatas = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			BoardData boardData = new BoardData();
			boardData.setPoster("작성자" + i);
			boardData.setSubject("제목" + i);
			boardData.setContents("내용" + i);
			boardData.setMember(member);
			
			boardDatas.add(boardData);
		}
		
		boardDatas = boardDataRepository.saveAll(boardDatas);
		System.out.println(boardDatas);
		
	}
	
	@GetMapping("/ex07")
	public void ex07() {
		BoardData data = boardDataRepository.findById(1L).orElse(null);
		Member member = data.getMember();
		System.out.println(member);
	}
	
	@GetMapping("/ex08")
	public void ex08() {
		Member member = repository.findMemberByMemId("user01");
		List<BoardData> data = member.getBoardDatas();
		for(BoardData bdata:data) {
			System.out.printf("%s,%s%n",bdata.getPoster(), bdata.getSubject());
		}
	}
	
	@GetMapping("/ex09")
	public void ex09() {
		//List<BoardData> list = boardDataRepository.findAll();
		List<BoardData> list = boardDataRepository.findDataAll();	// 즉시 로딩
		for(BoardData data:list) {
			Member member = data.getMember();
			System.out.println(member);
		}
	}
	
	@GetMapping("/ex10")
	public void ex10() {
		Member member = new Member();
		member.setMemId("user01");
		member.setMemNm("사용자01");
		member.setMemPw("1234");
		member.setEmail("user01@test.org");
		member.setMobile("01000000000");
		member = repository.save(member);
		
		member.setMemNm("(수정)사용자");
		repository.save(member);
		
	}
	
}
