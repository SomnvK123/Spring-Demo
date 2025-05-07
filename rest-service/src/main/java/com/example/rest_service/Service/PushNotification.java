package com.example.rest_service.Service;

import com.example.rest_service.Entity.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("pushNotification")
@Primary
public class PushNotification implements NotificationService {
    @Override
    public void notifyUser(String message, String recipient) {
        // Logic to send push notification
        System.out.println("Sending push notification to " + recipient + ": " + message);
    }
}
