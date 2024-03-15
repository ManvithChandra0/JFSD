package com.klef.jfsd.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.klef.jfsd.exam"})
public class MicroserviceLabExamProjectApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(MicroserviceLabExamProjectApplication.class, args);
		System.out.println("JFSD END SEM LAB EXAM ...");
	}
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
