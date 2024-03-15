package com.klef.jfsd.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UsersdpserviceApplication.class);
		
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
