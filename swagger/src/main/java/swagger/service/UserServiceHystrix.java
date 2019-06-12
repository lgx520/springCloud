package swagger.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import swagger.pojo.User;
/**
 * Feign服务调用
 * @author Neil
 *
 */
@FeignClient(value = "user", fallback = UserServiceImpl.class)
public interface UserServiceHystrix {
	
	/**
	 * 调用查询用户信息接口
	 * @param token
	 * @return
	 */
	@PostMapping(value = "/user/index")
	String index();
	
	/**
	 * 调用登录接口
	 */
	@PostMapping(value = "/user/login", consumes = "application/json")
	String login(@RequestBody User user);
}
