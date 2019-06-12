package com.product.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.product.service.LoginFeignService;

/**
 * 登录拦截
 * @author Neil
 *
 */
@Component
public class TokenInterceptor implements HandlerInterceptor{
	static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);	
	
	@Autowired
	private LoginFeignService loginFeignService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String loginCheck = this.loginFeignService.loginCheck();
		if ("success".equals(loginCheck)) {
			return true;
		}
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		

	}
	
	

}
