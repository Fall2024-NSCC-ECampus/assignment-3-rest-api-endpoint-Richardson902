package org.example.restapiendpoints.payload.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class StockUpdateRequest {
    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be greater than 0")
    private int quantity;
}
