package commons.auth;

import java.lang.reflect.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 회원일때 접근 통제
 * @author Administrator
 *
 */
public class MemberOnlyinterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		if(member == null) {// 로그인 하지 않는 경우(비회원)
			String url = request.getContextPath() + "/member/login";
								// /viewex - context path
			response.sendRedirect(url);
			return false;
		}
		
		return true;
	}
	
}
