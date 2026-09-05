package com.example.gestor_suscripciones.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="subscription")
public class Subscription {

    @Id
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @PrePersist
    public void generarId() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name="payment_date")
    private LocalDate paymentDate;
}