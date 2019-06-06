package com.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableEurekaClient //注册中心使用eureka
@EnableCircuitBreaker //开启服务监控
@EnableDiscoveryClient
@MapperScan("com.product.mapper")
@ComponentScan(basePackages = {"com.product.controller","com.product.service","com.product.ProductApplication"})
public class ProductApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}
