package com.product.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "product", fallback = ProductServiceImpl.class)
public interface ProductService {
	
	/**
	 * 查询商品
	 */
	@PostMapping("/product/getProductList")
	String getProductList();
	/**
	 * 查询商品详情
	 */
	@PostMapping("/product/getProductById/{id}")
	String getProductById(@PathVariable("id")Integer id);
	/**
	 * 健康检查Feign
	 */
	@RequestMapping("/product/success")
	String success();
}
