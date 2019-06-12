package com.product.service;

public interface ProductService {
	/**
	 * 查询商品
	 */
	String getProductList();
	/**
	 * 查询商品详情
	 */
	String getProductById(Integer id);
}
