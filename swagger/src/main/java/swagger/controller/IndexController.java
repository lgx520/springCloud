package swagger.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swagger.pojo.User;
import swagger.service.StatusService;
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
	@Autowired
	private StatusService statusService;
	
	/**
	 * 调用用户查询接口
	 */
	@PostMapping("/index")
	public String queryByUserId(HttpServletRequest request) {
		return userService.index();
	}
	
	/**
	 * 调用登录接口
	 */
	@PostMapping("/login")
	public String login(User user) {
		return userService.login(user);
	}
	
	/**
	 * 心跳
	 */
	@RequestMapping("/success")
	public String success() {
		return this.statusService.success();
	}
	
}
