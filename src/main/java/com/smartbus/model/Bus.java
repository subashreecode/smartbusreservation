package com.smartbus.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;



import java.time.LocalTime;

import java.util.List;

/*
Represents a bus assigned to a route.
 */

@Entity
public class Bus implements Comparable<Bus>{
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
    @JsonBackReference
    @JoinColumn(name="route_id")
    private Route route;
    //one to many
    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Seat> seats;

    //one to many
    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    //public static Comparator<Bus> byPrice = Comparator.comparing(Bus::getPrice);

    @Override
    public int compareTo(Bus other) {
        return this.departureTime.compareTo(other.departureTime);
    }

    public String testGetter() {
        return this.busNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }
}
