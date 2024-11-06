package org.example.restapiendpoints.repository;

import org.example.restapiendpoints.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
