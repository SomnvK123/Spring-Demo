package com.example.rest_service.Service;


import com.example.rest_service.Entity.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("smsNotification") // This name can be used to refer to this bean in the application context
@Primary // This will be the primary bean when multiple beans of the same type are present
public class SMSNotification implements NotificationService {
    @Override
    public void notifyUser(String message, String recipient) {
        // Logic to send SMS notification
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }

}
