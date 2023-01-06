package com.xpu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CommodityManageApplication {
	public static void main(String[] args) {

		SpringApplication.run(CommodityManageApplication.class, args);
	}

}
