package com.example.rest_service.Controller;

import com.example.rest_service.Entity.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


// Context class: Class sử dụng một đối tượng Strategy, có thể thay đổi chiến lược trong runtime.
@Component
public class NotificationSender {
    private final NotificationService notificationService;

    // Constructor injection: Injecting the strategy implementation
    public NotificationSender(@Qualifier("pushNotification") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification(String message, String recipient) {
        notificationService.notifyUser(message, recipient);
    }
}
