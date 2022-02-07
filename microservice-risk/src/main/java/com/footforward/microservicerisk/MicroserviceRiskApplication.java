package com.footforward.microservicerisk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.footforward.microservicerisk")
public class MicroserviceRiskApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRiskApplication.class, args);
	}

}
