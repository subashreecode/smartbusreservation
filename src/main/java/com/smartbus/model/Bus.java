package com.smartbus.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/*
Represents a bus assigned to a route.
 */
@Data
@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String busNumber;
    private String operatorName;

    private Integer totalSeats;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Double price;
    private Double rating;
    //many to one
    @ManyToOne
    @JoinColumn(name="route_id")
    private Route route;
    //one to many
    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Seat> seats;


    //one to many
    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reservation> reservations;






}
