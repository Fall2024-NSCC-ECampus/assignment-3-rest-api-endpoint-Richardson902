package org.example.restapiendpoints.payload.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PaymentRequest {
    @NotBlank
    @Positive
    private double amount;
}
