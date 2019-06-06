package swagger.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import swagger.bean.FeginClientConfig;
import swagger.pojo.User;
/**
 * Feign服务调用
 * @author Neil
 *
 */
@FeignClient(value = "user", fallback = UserServiceImpl.class, configuration = FeginClientConfig.class)
public interface UserService {
	
	/**
	 * 调用查询用户信息接口
	 * @param token
	 * @return
	 */
	@PostMapping(value = "/index")
	String index();
	
	/**
	 * 调用登录接口
	 */
	@PostMapping(value = "/login", consumes = "application/json")
	String login(@RequestBody User user);
}
