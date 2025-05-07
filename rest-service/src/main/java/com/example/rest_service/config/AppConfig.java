package com.example.rest_service.config;

import com.example.rest_service.beans.CustomScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.example.rest_service")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("fiveMinute", new CustomScope());
        return configurer;
    }
}
