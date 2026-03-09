package com.smartbus.service;

import org.springframework.stereotype.Component;

import com.smartbus.dto.BusSearchResponseDTO;
import com.smartbus.dto.ReservationResponseDTO;
import com.smartbus.model.Bus;
import com.smartbus.model.Reservation;


@Component
public class DtoMapper {

    public BusSearchResponseDTO toBusSearchDTO(Bus bus) {
        BusSearchResponseDTO dto = new BusSearchResponseDTO();
        dto.setId(bus.getId());
        dto.setBusNumber(bus.getBusNumber());
        dto.setOperatorName(bus.getOperatorName());
        dto.setSource(bus.getRoute().getSource());
        dto.setDestination(bus.getRoute().getDestination());
        dto.setDepartureTime(bus.getDepartureTime());
        dto.setArrivalTime(bus.getArrivalTime());
        dto.setPrice(bus.getPrice());
        dto.setRating(bus.getRating());
        return dto;
    }

    public ReservationResponseDTO toReservationDTO(Reservation reservation) {
        ReservationResponseDTO dto = new ReservationResponseDTO();

        dto.setReservationId(reservation.getId());
        dto.setJourneyDate(reservation.getJourneyDate());
        dto.setBookingTime(reservation.getBookingTime());
        dto.setStatus(reservation.getStatus().name());

        // User
        dto.setUserId(reservation.getUser().getId());
        dto.setUserName(reservation.getUser().getName());
        dto.setUserEmail(reservation.getUser().getEmail());

        // Bus
        dto.setBusId(reservation.getBus().getId());
        dto.setBusNumber(reservation.getBus().getBusNumber());
        dto.setOperatorName(reservation.getBus().getOperatorName());
        dto.setSource(reservation.getBus().getRoute().getSource());
        dto.setDestination(reservation.getBus().getRoute().getDestination());
        dto.setDepartureTime(reservation.getBus().getDepartureTime().toString());
        dto.setArrivalTime(reservation.getBus().getArrivalTime().toString());
        dto.setPrice(reservation.getBus().getPrice());

        // Seat
        dto.setSeatNumber(reservation.getSeat().getSeatNumber());

        return dto;
    }
}
