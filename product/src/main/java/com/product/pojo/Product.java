package com.product.pojo;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	//id
	private Integer id;
	//名称
	private String productName;
	//颜色
	private String productColor;
	//价格
	private Double productPrice;
	//热度
	private Integer productHeat;
	
	
	
	
	
	
	
	
	
	
	
	public Integer getProductHeat() {
		return productHeat;
	}
	public void setProductHeat(Integer productHeat) {
		this.productHeat = productHeat;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}
