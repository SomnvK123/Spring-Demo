package com.example.rest_service.Entity;


// Strategy interface: Khai báo phương thức chung cho tất cả các chiến lược.
public interface NotificationService {
     default void notifyUser(String message, String recipient) {
    }
}
