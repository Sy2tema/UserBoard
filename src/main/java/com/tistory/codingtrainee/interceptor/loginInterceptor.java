package com.tistory.codingtrainee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 사용자가 여러 작업을 수행하려 할 때 로그인이 되어있는지에 대한 여부를 확인해주는 역할을 담당한다
public class loginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션 객체를 생성한다
		HttpSession session = request.getSession();
		
		// 로그인이 되어있지 않은 상태라면 손님이라는 뜻으로 로그인 화면으로 돌려보낸다
		if (session.getAttribute("userid") == null) {
			response.sendRedirect(request.getContextPath() + "/user/login.do?message=guest");
			return false;
		}
		
		return true;
	}
	
}
