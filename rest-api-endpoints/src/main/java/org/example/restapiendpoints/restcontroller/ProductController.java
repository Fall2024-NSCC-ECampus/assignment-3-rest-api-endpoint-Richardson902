package org.example.restapiendpoints.restcontroller;

import jakarta.validation.Valid;
import org.example.restapiendpoints.model.Product;
import org.example.restapiendpoints.payload.product.PriceUpdateRequest;
import org.example.restapiendpoints.payload.product.StockUpdateRequest;
import org.example.restapiendpoints.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Product> addStock(@PathVariable Long id, @Valid @RequestBody StockUpdateRequest request) {
        Product product = productService.addStock(id, request.getQuantity());
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}/price")
    public ResponseEntity<Product> updatePrice(@PathVariable Long id, @Valid @RequestBody PriceUpdateRequest request) {
        Product product = productService.updatePrice(id, request.getPrice());
        return ResponseEntity.ok(product);
    }
}

