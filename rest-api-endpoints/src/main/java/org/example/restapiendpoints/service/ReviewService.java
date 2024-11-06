package org.example.restapiendpoints.service;

import org.example.restapiendpoints.model.Product;
import org.example.restapiendpoints.model.Review;
import org.example.restapiendpoints.repository.OrderRepository;
import org.example.restapiendpoints.repository.ProductRepository;
import org.example.restapiendpoints.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    public Review addReview(Review review) {
        // If doing it properly, you would want a user entity that has a userId
        // Then reference that ID here along with the product ID to ensure that
        // the user ordered the product before they can review it
        Optional<Product> productOptional = productRepository.findById(review.getProduct().getId());
        if (productOptional.isPresent()) {
            review.setProduct(productOptional.get());
            return reviewRepository.save(review);
        } else {
            throw new RuntimeException("Product not found with id " + review.getProduct().getId());
        }
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
