package com.footforward.microservicemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.footforward.microservicemodule")
public class MicroserviceModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceModuleApplication.class, args);
	}

}
