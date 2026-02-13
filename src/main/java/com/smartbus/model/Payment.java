package com.smartbus.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/*
Represents payment details for a reservation.
 */
@Data
@Entity
public class Payment  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservation;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private String transactionId;
    private LocalDateTime paymentTime;
    private String paymentMethod;

}
