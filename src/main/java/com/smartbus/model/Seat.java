package com.smartbus.model;

import jakarta.persistence.*;
import lombok.Data;

/*
Represents a seat inside a bus.

 */
@Data
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer seatNumber;
    private Boolean isBooked;
    //Many to one
    @ManyToOne()
    @JoinColumn(name="bus_id")
    private Bus bus;



}
