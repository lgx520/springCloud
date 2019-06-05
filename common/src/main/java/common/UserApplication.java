package common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 启动类,服务提供者
 * @author Neil
 *
 */
@SpringBootApplication
//@EnableEurekaClient //注册中心使用eureka
@EnableFeignClients //打开服务调用
@EnableCircuitBreaker //开启服务监控
@EnableDiscoveryClient
@MapperScan("common.mapper")
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
