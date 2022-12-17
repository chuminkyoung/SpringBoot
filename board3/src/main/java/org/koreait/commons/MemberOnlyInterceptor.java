package org.koreait.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.koreait.entity.Member;
import org.springframework.web.servlet.HandlerInterceptor;

public class MemberOnlyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 로그인 된 경우만 처리
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member"); // 회원 데이터 가져오기
		if(member != null) {	// 로그인 한 경우
			return true;
		}
		
		// 비회원인 경우 -> 로그인 페이지로 이동
		response.sendRedirect(request.getContextPath() + "/member/login");
		return false;
	}
	
}
