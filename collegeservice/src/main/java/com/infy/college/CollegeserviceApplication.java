package com.infy.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CollegeserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeserviceApplication.class, args);
	}

}
