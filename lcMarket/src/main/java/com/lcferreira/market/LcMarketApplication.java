package com.lcferreira.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LcMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(LcMarketApplication.class, args);
	}
}
