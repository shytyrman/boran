package com.example.boran.repository;

import com.example.boran.model.Order;
import com.example.boran.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserId(User user);
    List<Order> findAllByUserIdAndStatus(User user, String status);

    List<Order> findAllByStatus(String status);
    Order findFirstByTrackOrderByTimeDesc(String track);

}
