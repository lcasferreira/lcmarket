package com.lcferreira.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lcferreira.market.filter.SimpleCORSFilter;

@SpringBootApplication
@ComponentScan("com.lcferreira.market")
@EnableJpaRepositories
public class LcMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(LcMarketApplication.class, args);
	}
	
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SimpleCORSFilter getSimpleCORSFilter() {
		return new SimpleCORSFilter();
	}
}
