package com.product.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "product", fallback = ProductServiceImpl.class)
public interface ProductService {
	
	/**
	 * 查询商品
	 */
	@PostMapping("/product/getProductList")
	String getProductList();
}
