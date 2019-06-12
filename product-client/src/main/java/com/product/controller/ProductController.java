package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/**
	 * 查询所有商品
	 * @return
	 */
	@PostMapping("/getProductList")
	public String getProductList() {
		return productService.getProductList();
	}
	
	/**
	 * 查询商品详情
	 */
	@PostMapping("/getProductById/{id}")
	public String getProductById(@PathVariable("id")Integer id) {
		return productService.getProductById(id);
	}
	
	/**
	 * 用于健康检查
	 */
	@RequestMapping("/success")
	public String success() {
		return productService.success();
	}
}
