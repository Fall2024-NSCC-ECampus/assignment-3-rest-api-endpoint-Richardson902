package org.example.restapiendpoints.payload.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PriceUpdateRequest {
    @NotBlank
    @Positive
    private double price;
}
