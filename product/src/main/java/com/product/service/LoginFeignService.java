package com.product.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 登录验证
 * @author Neil
 *
 */
@FeignClient(value = "user")
public interface LoginFeignService {
	
	/**
	 * 调用登录验证
	 */
	@PostMapping("/user/loginCheck")
	String loginCheck();
}
