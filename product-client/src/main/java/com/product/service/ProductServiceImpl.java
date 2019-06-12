package com.product.service;

import org.springframework.stereotype.Component;

import com.product.util.ResultUtil;
import com.product.util.SystemEnum;

@Component
public class ProductServiceImpl implements ProductService{

	@Override
	public String getProductList() {
		ResultUtil<String> result = new ResultUtil<>();

		result.setResult(SystemEnum.PRODUCT_NO_DATA);
		return result.toString();
	}

	@Override
	public String getProductById(Integer id) {
		ResultUtil<String> result = new ResultUtil<>();

		result.setResult(SystemEnum.PRODUCT_NO_DATA);
		return result.toString();
	}

	@Override
	public String success() {
		ResultUtil<String> result = new ResultUtil<>();

		result.setResult(SystemEnum.SYSTEM_HYSTRIX);
		return result.toString();
	}


}
