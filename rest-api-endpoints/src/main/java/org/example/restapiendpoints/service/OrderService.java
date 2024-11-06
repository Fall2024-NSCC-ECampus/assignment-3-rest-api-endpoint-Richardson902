package org.example.restapiendpoints.service;

import org.example.restapiendpoints.model.Order;
import org.example.restapiendpoints.model.Product;
import org.example.restapiendpoints.repository.OrderRepository;
import org.example.restapiendpoints.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DeliveryService deliveryService;

    public Order placeOrder(Order order) {
        Optional<Product> productOptional = productRepository.findById(order.getProduct().getId());
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            if (product.getStock() >= order.getQuantity()) {
                product.setStock(product.getStock() - order.getQuantity());
                productRepository.save(product);
                order.setProduct(product); // ensures this bad boy is fully populated so it shows on the post request
                Order savedOrder = orderRepository.save(order);

                deliveryService.addDelivery(savedOrder);

                return savedOrder;

            } else {
                throw new RuntimeException("Insufficient stock for product with id " + product.getId());
            }
        } else {
            throw new RuntimeException("Product not found with id " + order.getProduct().getId());
        }

    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
