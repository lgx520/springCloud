package common.controller;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import common.pojo.User;
import common.service.UserService;

/**
 * 用户中心服务
 * @author Neil
 *
 */
@RestController
@RequestMapping("/user")
public class IndexController {
	static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 *根据id查询用户数据
	 * @return
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	@PostMapping("/index")
	public String queryUserId(HttpServletRequest request) {
		String token = request.getHeader("userToken");
		showLog("根据id查询用户数据", "queryUserId()", token);
		String queryUser = this.userService.queryUser(token);
		closeLog("根据id查询用户数据", "queryUserId()", queryUser);
		return queryUser;
	}
	
	/**
	 * 登录接口
	 */
	@PostMapping("/login")
	public String doLogin(@RequestBody User user) {
		showLog("登录", "doLogin()", user);
		String loginUser = this.userService.loginUser(user);
		closeLog("登录", "doLogin()", loginUser);
		return loginUser;
	}
	
	/**
	 * 退出登录接口
	 */
	@PostMapping("/exit")
	public String exit(HttpServletRequest request) {
		showLog("退出", "exit()", null);
		String token = request.getHeader("userToken");
		String exit = this.userService.exit(token);
		showLog("退出", "exit()", exit);
		return exit;
	}
	
	/**
	 * 用户登录校验
	 */
	@PostMapping("/loginCheck")
	public String loginCheck() {
		return "success";
	}
	
	/**
	 * 心跳接口
	 */
	@RequestMapping("/success")
	public String success() {
		return "Hello! SpringCloud!";
	}
	
	/**
	 * 日志输出
	 * @param name 方法描述
	 * @param methodName 方法名称
	 * @param obj 方法参数
	 */
	private void showLog(String name, String methodName, Object obj) {
		log.info("调用" + name + "接口，" + methodName + "。方法请求参数" + JSON.toJSONString(obj) + "\n");
	}
	private void closeLog(String name, String methodName, String obj) {
		log.info("调用" + name + "接口，" + methodName + "。方法结束返回：" + obj);
	}
}
