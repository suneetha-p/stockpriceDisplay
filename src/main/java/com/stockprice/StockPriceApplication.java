package com.stockprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.stockprice.*"})
@EnableJpaRepositories
public class StockPriceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockPriceApplication.class, args);
	}
}
