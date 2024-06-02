package com.team1060.golf.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        Info info = new Info().title("골프의민족").version("Golf v2").description("골프의 민족 2차 업데이트");
        return new OpenAPI().components(new Components()).info(info);
    }
}
