package com.mini.miniServer.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class Swagger2Config {
	
	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("v1-definition")
				.pathsToMatch("/api/**")
				.build();
	}
	
	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("mini API")
						.description("mini 프로젝트 API 명세서")
						.version("v0.0.1"));
	}

}
