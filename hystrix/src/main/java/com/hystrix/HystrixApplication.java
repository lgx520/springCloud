package com.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hyxtrix监控中心
 * @author Neil
 *访问地址: http://localhost:8777/hystrix
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixApplication.class, args);
	}
}
