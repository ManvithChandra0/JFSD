package com.klef.jfsd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurerkaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurerkaServerApplication.class, args);
		System.out.println("Eureka Server is Running...!!!");
	}

}
