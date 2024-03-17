package com.example.boran.controller;

import com.example.boran.model.Order;
import com.example.boran.model.User;
import com.example.boran.repository.OrderRepository;
import com.example.boran.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> orders = new ArrayList<Order>();
            orderRepository.findAll().forEach(orders::add);

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create_order")
    public ResponseEntity<String> saveOrder(@RequestBody Order order) {
        System.out.println(order.getDay());
        Optional<User> customer = userRepository.findUserByPhoneNumber(order.getUserPhoneNumber());
        orderRepository.save(new Order(order.getTrack(), order.getJPID(), customer.get(), order.getWeight(), order.getDay(), order.getPlace()));
        //orderRepository.save(order);
        return new ResponseEntity<String>("Succesfully registered", HttpStatus.OK);
    }

}







