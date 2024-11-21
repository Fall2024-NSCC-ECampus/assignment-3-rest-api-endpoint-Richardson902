package org.example.restapiendpoints.payload.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PriceUpdateRequest {
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private double price;
}
