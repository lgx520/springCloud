package com.product.mapper;

import java.util.List;
import org.springframework.stereotype.Component;

import com.product.pojo.Product;

@Component
public interface ProductMapper {
	/**
	 * 查询数据
	 * @param product
	 * @return
	 */
	List<Product> getProductList(Product product);
}
