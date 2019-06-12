package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 服务消费者
 * @author Neil
 */
@SpringBootApplication
@EnableFeignClients //打开服务调用
@EnableCircuitBreaker //开启服务监控
@EnableDiscoveryClient
public class ProductClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductClientApplication.class, args);
	}
}
