package com.product.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ResultUtil<T> {
	/**
	 * 错误枚举类
	 */
	private SystemEnum result;
	/**
	 * 数据
	 */
	private T data;
	
	public ResultUtil() {
		this.result = null;
	}
	
	@Override
	public String toString() {
		JSONObject obj = new JSONObject();
		
		obj.put("code", result.getCode());
		obj.put("desc", result.getDesc());
		obj.put("data", data);
		
		return JSON.toJSONString(obj);
	}
	
	public void setResult(SystemEnum result) {
		this.result = result;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	public SystemEnum getResult() {
		return result;
	}

	public T getData() {
		return data;
	}
}
