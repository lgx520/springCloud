package com.product.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {
	
	String getKey(String key);
	
	void setValue(String key, String value);
	
	void remove(String key);
	
	void setValueTime(String key, String value, long timeout, TimeUnit unit);
}
