package com.smartbus.dto;

import java.time.LocalTime;

public class BusSearchResponseDTO {

    private Long id;
    private String busNumber;
    private String operatorName;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Double price;
    private Double rating;
    private RouteDTO route;
    private String source;
    private String destination;

    public BusSearchResponseDTO(Long id, String busNumber, String operatorName,
                  LocalTime departureTime, LocalTime arrivalTime,
                  Double price, Double rating, RouteDTO route) {
        this.id = id;
        this.busNumber = busNumber;
        this.operatorName = operatorName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.rating = rating;
        this.route = route;
    }

    public BusSearchResponseDTO() {}

    public BusSearchResponseDTO(Long id, String busNumber, String operatorName, LocalTime departureTime, LocalTime arrivalTime, Double price) {
        this.id = id;
        this.busNumber = busNumber;
        this.operatorName = operatorName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RouteDTO getRoute() {
        return route;
    }

    public void setRoute(RouteDTO route) {
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

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public void setSource(String source) {
        this.source = source;

    }

    public void setDestination(String destination) {

        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }


    public class RouteDTO {

        private Long id;
        private String source;
        private String destination;
        private Double distanceKm;

        public RouteDTO(Long id, String source, String destination, Double distanceKm) {
            this.id = id;
            this.source = source;
            this.destination = destination;
            this.distanceKm = distanceKm;
        }

        public RouteDTO() {}

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Double getDistanceKm() {
            return distanceKm;
        }

        public void setDistanceKm(Double distanceKm) {
            this.distanceKm = distanceKm;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }

}
