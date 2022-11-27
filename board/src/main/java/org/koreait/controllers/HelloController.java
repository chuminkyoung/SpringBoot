package org.koreait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.*;

@Controller
public class HelloController {
	private String name;
	@GetMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("message", "안녕!");
		return "hello";
	}
}
