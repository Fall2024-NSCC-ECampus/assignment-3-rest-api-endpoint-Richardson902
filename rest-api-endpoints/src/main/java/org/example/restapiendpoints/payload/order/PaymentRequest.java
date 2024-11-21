package org.example.restapiendpoints.payload.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PaymentRequest {
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private double amount;
}
