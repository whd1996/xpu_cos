package com.xpu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.xpu.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class BuyServiceApplication {
	public static void main(String[] args) {

		SpringApplication.run(BuyServiceApplication.class, args);
	}
}
