package com.product.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.product.service.RedisService;

/**
 * redis工具类
 * @author Neil
 *
 */
@Service
public class RedisServiceImpl implements RedisService{
	
	@Autowired
	private StringRedisTemplate template;
	
	/**
	 * 根据Key获得Value
	 * @param key
	 * @return
	 */
	@Override
	public String getKey(String key) {
		return this.template.opsForValue().get(key);
	}
	/**
	 * 保存key和Value
	 * @param key
	 * @param value
	 */
	@Override
	public void setValue(String key, String value) {
		this.template.opsForValue().set(key, value);
	}
	/**
	 * 删除
	 */
	@Override
	public void remove(String key) {
		this.template.delete(key);
	}
	/**
	 * 保存有过期时间的值
	 */
	@Override
	public void setValueTime(String key, String value, long timeout, TimeUnit unit) {
		this.template.opsForValue().set(key, value, timeout, unit);
	}
	
}
