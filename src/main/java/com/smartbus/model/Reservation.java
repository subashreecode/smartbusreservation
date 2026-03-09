package com.smartbus.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDate;
import java.time.LocalDateTime;

/*
Represents a booking made by a user.
 */

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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate journeyDate;
    private LocalDateTime bookingTime;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    @OneToOne(mappedBy = "reservation",cascade = CascadeType.ALL)
    private Payment payment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(LocalDate journeyDate) {
        this.journeyDate = journeyDate;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
