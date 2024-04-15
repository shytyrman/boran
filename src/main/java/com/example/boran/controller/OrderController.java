package com.example.boran.controller;

import com.example.boran.model.Order;
import com.example.boran.model.User;
import com.example.boran.repository.CurrencyRepository;
import com.example.boran.repository.OrderRepository;
import com.example.boran.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CurrencyRepository currencyRepository;

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
        Order dbOrder = null;
        try {
            System.out.println(0);
            Optional<User> customer = userRepository.findUserByPhoneNumber(order.getUserPhoneNumber());
            BigDecimal currentDollar = currencyRepository.findFirstByOrderByDayDesc().getDollar();
            float cost = (float) ((order.getBoxnum() * 2 + order.getWeight() * 6.3 + 1) * currentDollar.doubleValue());
            dbOrder = orderRepository.save(
                    new Order(
                            order.getTrack(),
                            order.getJPID(),
                            customer.get(),
                            order.getWeight(),
                            order.getPlace(),
                            order.getBoxnum(),
                            Timestamp.valueOf(LocalDateTime.now()),
                            cost,
                            order.getStatus()
                    )
            );
            //orderRepository.save(order);
            return new ResponseEntity<String>("Succesfully registered", HttpStatus.OK);
        } finally {

            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            final Order finalDbOrder = dbOrder;
            executorService.schedule(() -> {
                orderRepository.save(
                        new Order(
                                finalDbOrder.getTrack(),
                                finalDbOrder.getJPID(),
                                finalDbOrder.getUserId(),
                                finalDbOrder.getWeight(),
                                finalDbOrder.getPlace(),
                                finalDbOrder.getBoxnum(),
                                Timestamp.valueOf(LocalDateTime.now()),
                                finalDbOrder.getCost(),
                                "Border"
                        )
                );
            }, 84000, TimeUnit.SECONDS);
        }
    }

    @GetMapping("/user_orders")
    public ResponseEntity<List<Order>> getUserOrders(@RequestParam String phoneNumber) {
        try {
            Optional<User> user = userRepository.findUserByPhoneNumber(phoneNumber);
            List<Order> orders = orderRepository.findAllByUserId(user.get());

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/order_by_track")
    public ResponseEntity<Order> getTrackOrder(@RequestParam String track) {
        try {
            Order order = orderRepository.findFirstByTrackOrderByTimeDesc(track);

            if (order == null) {
                return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
            }

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();
            User user = order.getUserId();
            System.out.println("User: " + user.getPhoneNumber());
            System.out.println("Login: " + username);
            System.out.println("Role: " + user.getUserRole());
            System.out.println("Name check: " + username.equals(user.getPhoneNumber()));
            System.out.println("Role check: " + user.getUserRole().equals("ADMIN"));
            if (username.equals(user.getPhoneNumber()) || user.getUserRole().equals("ADMIN")) {
                return new ResponseEntity<Order>(order, HttpStatus.OK);
            }
            return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}