package org.koreait.controllers.boards;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.koreait.entity.BoardData;
import org.koreait.entity.Member;
import org.koreait.service.boards.BoardDataSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/write")
public class BoardWriteController {
	
	@Autowired
	private BoardDataSaveService service;
	
	@GetMapping
	public String form(Model model, HttpSession session) {
		
		BoardRequest boardRequest = new BoardRequest();
		Member member = (Member)session.getAttribute("member");
		if(member != null) {
			boardRequest.setPoster(member.getMemNm());
		}
		
		model.addAttribute("boardRequest", boardRequest);
		
		return "board/write";
	}
	
	@PostMapping
	public String process(@Valid BoardRequest boardRequest, Errors errors) {
		
		if(errors.hasErrors()) {
			return "board/write";
		}
		
		BoardData boardData = service.process(boardRequest);
		
		return "redirect:/board/view/" + boardData.getId();
	}
}
