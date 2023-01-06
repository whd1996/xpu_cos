package com.xpu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xpu.dao")
public class PurchaseorderManageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseorderManageServiceApplication.class, args);
	}

}
