package org.example.restapiendpoints.repository;

import org.example.restapiendpoints.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
