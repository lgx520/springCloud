package common.interceptor;

import java.io.IOException;
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
import common.service.redis.RedisService;
import common.util.ResultUtil;
import common.util.SystemEnum;
import common.util.TokenUtil;

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
	
	static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);
	
	@Autowired
	private RedisService redisService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		if (!request.getRequestURI().contains(LOGIN)) {
			//拿出token
			String token = request.getHeader(TOKEN_NAME);
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
					sendRedirect(response, request);
					return false;
				}
			} else {
				sendRedirect(response, request);
				return false;
			}
		} else {
			//进入登录页面不拦截
			return true;
		}
	}
	
	private void sendRedirect(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String status = request.getHeader("status");
		System.out.println(status);
		if ("ajax".equals(status)) {
			ResultUtil<String> result = new ResultUtil<>();
			result.setResult(SystemEnum.SYSTEM_TOKEN);
			result.setData("http://localhost/login.html");
			response.getWriter().write(result.toString());
		} else {
			response.sendRedirect("http://localhost/login.html");
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
