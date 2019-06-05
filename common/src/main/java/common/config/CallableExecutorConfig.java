package common.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 线程池配置类
 * @author Neil
 *
 */
@Configuration
public class CallableExecutorConfig {
	
	@Bean
	public ExecutorService getPool() {
		return Executors.newFixedThreadPool(10);
	}
}
