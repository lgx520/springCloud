package com.product.interceptor;

import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.product.service.RedisService;
import com.product.util.TokenUtil;

/**
 * 登录拦截
 * @author Neil
 *
 */
@Component
public class TokenInterceptor implements HandlerInterceptor{
	private static final String TOKEN_NAME = "userToken";
	private static final String LOGIN = "login";
	private static final String USER_ID = "id";
	private static final String LOGIN_HEML = "/login.html";
	
	static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);
	@Autowired
	private RedisService redisService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//拿出token
		String token = request.getHeader(TOKEN_NAME);
		//判断当前页面是否是登录页面
		if (!request.getRequestURI().contains(LOGIN)) {
			//校验token
			DecodedJWT doToken = TokenUtil.doToken(token);
			if (doToken != null) {
				String userId = doToken.getClaim(USER_ID).asInt().toString();
				//从redis中拿出token比较
				String code = this.redisService.getKey(userId);
				if (null != code && !"".equals(code) && code.equals(token)) {
					//校验成功,重新设置过期时间
					this.redisService.setValueTime(userId, token, 1, TimeUnit.HOURS);
					log.info("用户" + userId + "通过拦截器，授权访问！");
					return true;
				} else {
					response.setContentType("text/html;charset=utf-8");
					//token过期，重新登录
					response.sendRedirect("/login.html");
					//设置请求头
					response.addHeader("REDIRECT", "REDIRECT");//告诉ajax这是重定向 
					response.addHeader("CONTEXTPATH", LOGIN_HEML);//重定向地址
					return false;
				}
			} else {
				response.setContentType("text/html;charset=utf-8");
				//token失效
				response.sendRedirect("/login.html");
				//设置请求头
				response.addHeader("REDIRECT", "REDIRECT");//告诉ajax这是重定向 
				response.addHeader("CONTEXTPATH", LOGIN_HEML);//重定向地址
				return false;
			}
		} else {
			//进入登录页面不拦截
			return true;
		}
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
