package org.example.restapiendpoints.repository;

import org.example.restapiendpoints.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
