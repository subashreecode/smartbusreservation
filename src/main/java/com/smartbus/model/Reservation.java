package com.smartbus.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
Represents a booking made by a user.
 */
@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="bus_id")
    private Bus bus;
    @OneToOne
    @JoinColumn(name="seat_id")
    private Seat seat;
    private LocalDate journeyDate;
    private LocalDateTime bookingTime;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    @OneToOne(mappedBy = "reservation",cascade = CascadeType.ALL)
    private Payment payment;





}
