package swagger.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 状态接口
 * @author Neil
 *
 */
@FeignClient(value = "user")
public interface StatusService {

	@RequestMapping("/success")
	String success();
}
