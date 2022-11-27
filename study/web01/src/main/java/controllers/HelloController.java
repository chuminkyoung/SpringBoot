package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(String name, Model model) {
		model.addAttribute("name", name);
		return "hello";	// /WEB-INF/view/hello.jsp
	}
	
}
