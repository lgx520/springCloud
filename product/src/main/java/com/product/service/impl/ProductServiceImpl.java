package com.product.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.mapper.ProductMapper;
import com.product.pojo.Product;
import com.product.service.ProductService;
import com.product.util.CheckUtil;
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
	
	/**
	 * 查询商品详情
	 */
	@Override
	public String getProductById(Integer id) {
		ResultUtil<Product> result = new ResultUtil<>();
		try {
			CheckUtil.isNotNull(id);
		} catch (Exception e) {
			log.error("", e);
			result.setResult(SystemEnum.SYSTEM_PARAM_NULL);
			return result.toString();
		}
		
		Product product = new Product();
		product.setId(id);
		try {
			List<Product> productList = this.productMapper.getProductList(product);
			if (productList != null) {
				result.setData(productList.get(0));
				result.setResult(SystemEnum.SYSTEM_SUCCESS);
			}
		} catch (Exception e) {
			log.error("", e);
			result.setResult(SystemEnum.SYSTEM_ERROR);
		}
		return result.toString();
	}

}
