package com.example.notifier;


import org.springframework.stereotype.Component;

@Component
public class CustomerEventNotifier {


    public void sendEmail() {
        System.out.println("Sending Email");
    }
}
