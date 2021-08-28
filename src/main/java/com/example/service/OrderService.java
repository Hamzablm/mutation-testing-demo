package com.example.service;

import com.example.notifier.CustomerEventNotifier;
import com.example.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private CustomerEventNotifier notifier;

    public void placeOrder(List<Product> products) {
        if (products.isEmpty()) {
            throw new IllegalStateException("You need to select products to place an order");
        }

        if (products.size() > 2) {
            notifier.sendEmail();
        }
    }

}
