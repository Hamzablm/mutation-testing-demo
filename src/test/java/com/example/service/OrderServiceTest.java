package com.example.service;

import com.example.domain.Product;
import com.example.notifier.CustomerEventNotifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private CustomerEventNotifier customerEventNotifier;

    @InjectMocks
    private OrderService orderService;

    @Test
    void placeOrder_should_throw_exception_when_list_of_products_is_empty() {
        assertThrows(IllegalStateException.class, () -> orderService.placeOrder(Collections.emptyList()));
        Mockito.verify(customerEventNotifier, Mockito.times(0)).sendEmail();
    }

    @Test
    void placeOrder_should_send_email_to_customer_when_there_is_more_than_two_products() {
        List<Product> products = List.of(
                new Product(32.4, "Lean Startup", false),
                new Product(43.5, "Head First Java", true),
                new Product(21.67, "Java Concurrency in Practice", true));
        orderService.placeOrder(products);
    }

}