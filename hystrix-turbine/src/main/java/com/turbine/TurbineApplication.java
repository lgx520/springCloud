package com.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Turbine聚合监控中心
 * @author Neil
 *聚合数据地址 : http://localhost:8778/turbine.stream
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApplication {
	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}
}
