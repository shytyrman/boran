package com.example.boran.controller;

import com.example.boran.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderController {

    @Autowired
    OrderRepository orderRepository;
}
