package org.example.restapiendpoints.repository;


import org.example.restapiendpoints.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
