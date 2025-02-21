package com.example.DealerWebSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiDealerWebApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ApiDealerWebApplication.class, args);
	}

}
