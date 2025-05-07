package com.example.rest_service;

import com.example.rest_service.Controller.NotificationSender;
import com.example.rest_service.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		NotificationSender sender = context.getBean(NotificationSender.class);

		sender.sendNotification("Hello, World!", "Zero Two");
		context.close();
//		SpringApplication.run(RestServiceApplication.class, args);

	}

}
