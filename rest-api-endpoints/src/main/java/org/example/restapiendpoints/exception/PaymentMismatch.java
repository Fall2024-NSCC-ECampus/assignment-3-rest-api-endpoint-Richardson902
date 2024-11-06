package org.example.restapiendpoints.exception;

public class PaymentMismatch extends RuntimeException {
    public PaymentMismatch(String message) {
        super(message);
    }
}
