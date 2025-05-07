package com.example.rest_service.Service;

import com.example.rest_service.Entity.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("emailNotification") // This name can be used to refer to this bean in the application context
@Primary

// Concrete strategies: Các class triển khai interface trên, mỗi class là một chiến lược cụ thể.
public class EmailNotification implements NotificationService {
    @Override
    public void notifyUser(String message, String recipient) {
        // Logic to send email notification
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}
