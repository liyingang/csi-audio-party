package com.jit.csi.configuration.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的URL
		String url = request.getRequestURI();
		// URL:除了登录请求外，其他的URL都进行拦截控制
		if (url.contains("login")||url.contains("register")) {
			return true;
		}
		// 获取Session
		HttpSession session = request.getSession();
		// 判断Session中是否有用户数据，如果有，则返回true,继续向下执行
		if(session.getAttribute("user") != null)
			return true;
		// 不符合条件的给出提示信息，并转发到登录页面
		request.setAttribute("msg", "您还没有登录，请先登录！");
		response.sendRedirect("http://localhost/login.html");
		return false;
	}
	@Override
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
