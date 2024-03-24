package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domains.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
/**
 * Конструктор класса
 * */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public void sendNotification(String s) {
        System.out.println(s);
    }
}
