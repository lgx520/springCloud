package swagger.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import swagger.pojo.User;
/**
 * Feign服务调用
 * @author Neil
 *
 */
@FeignClient(value = "user", fallback = UserServiceImpl.class)
public interface UserService {
	
	/**
	 * 调用查询用户信息接口u
	 * @param token
	 * @return
	 */
	@RequestMapping("/index")
	String index(String token);
	
	/**
	 * 调用登录接口
	 */
	@PostMapping("/login")
	String login(User user);
}
