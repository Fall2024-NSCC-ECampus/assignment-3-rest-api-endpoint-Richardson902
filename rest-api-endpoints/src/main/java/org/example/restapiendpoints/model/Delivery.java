package org.example.restapiendpoints.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;

    @Column(name = "delivery_status", nullable = false)
    private String deliveryStatus;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
