package org.example.restapiendpoints.service;

import org.example.restapiendpoints.model.Delivery;
import org.example.restapiendpoints.model.Order;
import org.example.restapiendpoints.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery addDelivery(Order order) {
        Delivery delivery = new Delivery();
        delivery.setDeliveryAddress(order.getAddress());
        delivery.setOrder(order);
        delivery.setDeliveryStatus("PENDING");
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }

    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }

    public Delivery updateDeliveryStatus(Long id, String status) {
        Optional<Delivery> deliveryOptional = deliveryRepository.findById(id);
        if (deliveryOptional.isPresent()) {
            Delivery delivery = deliveryOptional.get();
            delivery.setDeliveryStatus(status);
            return deliveryRepository.save(delivery);
        } else {
            throw new RuntimeException("Delivery not found with id " + id);
        }
    }
}
