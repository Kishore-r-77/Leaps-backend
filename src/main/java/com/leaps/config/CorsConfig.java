package com.leaps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.leaps.utilities.RestMethods;

@Configuration
public class CorsConfig {

	private static final String POST = RestMethods.POST;
	private static final String DELETE = RestMethods.DELETE;
	private static final String GET = RestMethods.GET;
	private static final String PUT = RestMethods.PUT;
	private static final String PATCH = RestMethods.PATCH;

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
				.addMapping("/**")
				.allowedMethods(GET, PUT, PATCH, DELETE, POST)
				.allowedOrigins("*")
				.allowedHeaders("*")
				.allowedOriginPatterns("*");
//				.allowCredentials(true);
			}
		};

	}
}
