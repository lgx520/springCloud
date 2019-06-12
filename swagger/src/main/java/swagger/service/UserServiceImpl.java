package swagger.service;

import org.springframework.stereotype.Component;

import swagger.pojo.User;
import swagger.util.ResultUtil;
import swagger.util.SystemEnum;

/**
 * 服务熔断,降级
 */
@Component
public class UserServiceImpl implements UserServiceHystrix,UserService{

	@Override
	public String index() {
		ResultUtil<String> result = new ResultUtil<>();
		result.setResult(SystemEnum.SYSTEM_HYSTRIX);
		return result.toString();
	}

	@Override
	public String login(User user) {
		ResultUtil<String> result = new ResultUtil<>();
		result.setResult(SystemEnum.SYSTEM_HYSTRIX);
		return result.toString();
	}

	@Override
	public String exit() {
		ResultUtil<String> result = new ResultUtil<>();
		result.setResult(SystemEnum.SYSTEM_HYSTRIX);
		return result.toString();
	}

	@Override
	public String success() {
		ResultUtil<String> result = new ResultUtil<>();
		result.setResult(SystemEnum.SYSTEM_HYSTRIX);
		return result.toString();
	}
	
}
