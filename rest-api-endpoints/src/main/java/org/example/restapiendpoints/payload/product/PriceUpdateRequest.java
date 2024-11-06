package org.example.restapiendpoints.payload.product;

import lombok.Data;

@Data
public class PriceUpdateRequest {
    private double price;
}
