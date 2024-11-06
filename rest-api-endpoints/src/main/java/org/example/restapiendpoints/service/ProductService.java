package org.example.restapiendpoints.service;

import org.example.restapiendpoints.exception.NotFound;
import org.example.restapiendpoints.model.Product;
import org.example.restapiendpoints.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Gets rid of the redundant Optional wrapper (yucky)
    private Product findProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            throw new NotFound("Product not found with id " + id);
        }
    }

    public Product addStock(Long id, int quantity) {
        Product product = findProductById(id);
        product.setStock(product.getStock() + quantity);
        return productRepository.save(product);

    }

    public Product updatePrice(Long id, double price) {
        Product product = findProductById(id);
        product.setPrice(price);
        return productRepository.save(product);
    }
}
