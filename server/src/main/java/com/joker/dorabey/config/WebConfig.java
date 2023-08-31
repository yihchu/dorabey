package com.joker.dorabey.config;

import com.joker.dorabey.DRBApplication;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:30001/")
                .allowedMethods("GET", "POST")
                .allowCredentials(true)
                .allowedHeaders("*")
                .maxAge(3600);
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        DRBApplication.ctx = ctx;
    }

}
