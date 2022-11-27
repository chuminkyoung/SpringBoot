package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");	
		// resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();	// 응답하는 역할
		out.print("<h1>안녕하세요</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");	// 메서드 상관 없이
		String memPw = req.getParameter("memPw");
		
		System.out.printf("memId=%s, emePw=%s%n", memId, memPw);
		
	}	// 사용자가 요청한 데이터를 가져옴
	
}
