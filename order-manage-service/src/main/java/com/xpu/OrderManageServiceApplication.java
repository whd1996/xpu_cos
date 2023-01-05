package com.xpu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xpu.dao")
public class OrderManageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManageServiceApplication.class, args);
	}

}
