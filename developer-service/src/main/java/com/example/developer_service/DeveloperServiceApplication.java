package com.example.developer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeveloperServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeveloperServiceApplication.class, args);
	}

}
