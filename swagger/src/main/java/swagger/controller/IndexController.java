package swagger.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swagger.pojo.User;
import swagger.service.UserService;
import swagger.service.UserServiceHystrix;

/**
 * 用户中心服务消费者
 * @author Neil
 *
 */
@RestController
@RequestMapping("/user")
public class IndexController {
	
	@Autowired
	private UserServiceHystrix userServiceHystrix;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 调用用户查询接口
	 */
	@PostMapping("/index")
	public String queryByUserId(HttpServletRequest request) {
		return userServiceHystrix.index();
	}
	
	/**
	 * 调用登录接口
	 */
	@PostMapping("/login")
	public String login(User user) {
		return userServiceHystrix.login(user);
	}
	
	/**
	 * 退出登录
	 */
	@PostMapping("/exit")
	public String exit() {
		return userService.exit();
	}
	
	/**
	 * 心跳
	 */
	@RequestMapping("/success")
	public String success() {
		return userService.success();
	}
	
}
