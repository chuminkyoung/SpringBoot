package org.koreait.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.koreait.entity.Member;
import org.springframework.web.servlet.HandlerInterceptor;

public class GuestOnlyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 비회원 전용
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		if(member == null) {	// 비회원 일때만 가능
			return true;
		}
		
		// 회원인 경우 -> 메인페이지 이동
		response.sendRedirect(request.getContextPath() + "/");
		
		return false;
	}
	
}
