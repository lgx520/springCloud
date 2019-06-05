package swagger.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swagger.pojo.User;
import swagger.service.UserService;

/**
 * 用户中心服务消费者
 * @author Neil
 *
 */
@RestController
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 调用用户查询接口
	 */
	@RequestMapping("/index")
	public String queryByUserId(HttpServletRequest request) {
		String token = request.getHeader("userToken");
		return userService.index(token);
	}
	
	/**
	 * 调用登录接口
	 */
	@RequestMapping("/login")
	public String login(User user) {
		return userService.login(user);
	}
	
}
