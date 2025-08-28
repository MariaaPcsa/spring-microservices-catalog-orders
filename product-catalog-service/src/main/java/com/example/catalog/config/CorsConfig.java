package com.example.catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Lê os domínios permitidos da variável de ambiente ALLOWED_ORIGINS
                // Se não existir, usa localhost:5173 como padrão
                String originsEnv = System.getenv("ALLOWED_ORIGINS");
                String[] allowedOrigins = originsEnv != null
                        ? originsEnv.split(",")
                        : new String[]{"http://localhost:5173"};

                System.out.println("🔐 CORS liberado para: " + Arrays.toString(allowedOrigins));

                registry.addMapping("/**")
                        .allowedOrigins(allowedOrigins)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true); // Necessário se for usar cookies ou Authorization header
            }
        };
    }
}
