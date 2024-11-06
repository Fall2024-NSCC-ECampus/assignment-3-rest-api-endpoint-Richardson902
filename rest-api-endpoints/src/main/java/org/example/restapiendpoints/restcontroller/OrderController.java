package org.example.restapiendpoints.restcontroller;

import org.example.restapiendpoints.model.Order;
import org.example.restapiendpoints.payload.order.PaymentRequest;
import org.example.restapiendpoints.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order savedOrder = orderService.placeOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<Order> payForOrder(@PathVariable Long id, @RequestBody PaymentRequest request) {
        Order order = orderService.payForOrder(id, request.getAmount());
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getOrders();
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
