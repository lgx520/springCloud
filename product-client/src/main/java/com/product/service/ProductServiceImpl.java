package com.product.service;

import com.product.util.ResultUtil;
import com.product.util.SystemEnum;

public class ProductServiceImpl implements ProductService{

	@Override
	public String getProductList() {
		ResultUtil<String> result = new ResultUtil<>();
		
		result.setResult(SystemEnum.PRODUCT_NO_DATA);
		return result.toString();
	}
	
	
}
