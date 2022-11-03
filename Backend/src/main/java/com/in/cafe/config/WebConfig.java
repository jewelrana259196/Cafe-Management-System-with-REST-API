package com.in.cafe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200/")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                .allowedHeaders("Origin", "Access-Control-Allow-Origin", "Content-Type",
                        "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                        "Access-Control-Request-Method", "Access-Control-Allow-Origin",
                        "Access-Control-Request-Headers")
                .exposedHeaders("Authorization", "content-type", "Access-Control-Allow-Origin",
                        "Access-Control-Allow-Credentials", "Access-Control-Allow-Headers",
                        "Access-Control-Allow-Methods", "Access-Control-Request-Headers",
                        "Access-Control-Request-Method", "Origin", "Accept", "X-Requested-With")
                .allowCredentials(true);
    }
}
