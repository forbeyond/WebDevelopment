package com.webdevelopment.developweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,
				             HttpServletResponse response,
				             Object handler) throws Exception {
		if(request.getSession().getAttribute("username") != null) {
			return true;
		}
		request.getSession().setAttribute("next", request.getRequestURI());
		//response.sendRedirect("/login?next=".concat(request.getRequestURI()));
		response.sendRedirect("/login");
		return false;
	}
}
