package com.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.mapper.ProductMapper;
import com.product.pojo.Product;
import com.product.util.ResultUtil;
import com.product.util.SystemEnum;

@Service
public class ProductServiceImpl implements ProductService{
	static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public String getProductList() {
		ResultUtil<Product> result = new ResultUtil<>();
		try {
			List<Product> productList = this.productMapper.getProductList(null);
			if (productList != null && !productList.isEmpty()) {
				result.setDataList(productList);
				result.setResult(SystemEnum.SYSTEM_SUCCESS);
			} else {
				result.setResult(SystemEnum.PRODUCT_NO_DATA);
			}
		} catch (Exception e) {
			log.info("", e);
			result.setResult(SystemEnum.SYSTEM_ERROR);
		}
		
		return result.toString();
	}

}
