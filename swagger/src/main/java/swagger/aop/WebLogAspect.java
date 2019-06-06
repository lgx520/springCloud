package swagger.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

@Aspect
@Component
public class WebLogAspect {
	private static final Logger log = LoggerFactory.getLogger(WebLogAspect.class);

	/**
	 * 配置所需要切面类的路径
	 */
	@Pointcut("execution(public * swagger.controller..*.*(..))")
	public void webLog(){

	}
	
	/**
	 * 进入方法时
	 * @param joinPoint
	 */
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		log.info("IP:" + request.getRemoteAddr() + "，发起请求。");
		log.info("请求路径：URL : " + request.getRequestURL().toString());
		log.info("请求方法： : " + request.getMethod());
		Enumeration<String> enu = request.getParameterNames();
		log.info("请求参数：");
		while (enu.hasMoreElements()) {
			String name = enu.nextElement().toString();
			log.info("name:{},value:{}", name, request.getParameter(name));
		}        
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		log.info("方法返回参数 : " + JSON.toJSONString(ret));
	}
}
