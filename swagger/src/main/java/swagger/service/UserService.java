package swagger.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 不进行熔断接口
 * @author Neil
 *
 */
@FeignClient(value = "user", fallback = UserServiceImpl.class)
public interface UserService {
	
	@PostMapping("/user/exit")
	String exit();
	
	@RequestMapping("/user/success")
	String success();
}
