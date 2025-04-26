package com.biblioteca.gestorlivros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite em todos os endpoints
                        .allowedOrigins("*") // Permite qualquer origem (inclusive file://)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Métodos que serão aceitos
            }
        };
    }
}