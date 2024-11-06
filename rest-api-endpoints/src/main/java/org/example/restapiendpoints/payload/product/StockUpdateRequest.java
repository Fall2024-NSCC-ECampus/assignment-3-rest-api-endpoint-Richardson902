package org.example.restapiendpoints.payload.product;

import lombok.Data;

@Data
public class StockUpdateRequest {
    private int quantity;
}
