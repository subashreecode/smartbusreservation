package com.smartbus.service;

import com.smartbus.model.*;
import com.smartbus.repository.BusRepository;
import com.smartbus.repository.ReservationRepository;
import com.smartbus.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BusRepository busRepository;

    public Reservation reserveSeat(Long busId, Long seatId, Long userId, LocalDate journeyDate)
    {
        Bus bus = busRepository.findById(busId).
                orElseThrow(()->new RuntimeException("Bus not found"));
        Seat seat = seatRepository.findById(seatId).
                orElseThrow(()->new RuntimeException("Seat not found"));
         validateSeatAvailability(seat,journeyDate);
         seat.setBooked(true);
         Reservation reservation = new Reservation();
         reservation.setBus(bus);
         reservation.setSeat(seat);
         reservation.setUser(new User(userId));
         reservation.setJourneyDate(journeyDate);
         reservation.setBookingTime(LocalDateTime.now());
         reservation.setStatus(ReservationStatus.BOOKED);
        return reservationRepository.save(reservation);
    }

    private void validateSeatAvailability(Seat seat, LocalDate date) {
        if (Boolean.TRUE.equals(seat.getBooked())) {
            throw new RuntimeException("Seat already booked");
        }
        boolean exists = reservationRepository.existsBySeatIdAndJourneyDate(seat.getId(), date);
        if (exists) {
            throw new RuntimeException("Seat already reserved for this date");
        }
    }
    public void cancelReservation(Long reservationId)
    {
       Reservation reservation = reservationRepository.findById(reservationId).
               orElseThrow(()->new RuntimeException("Reservation not found"));
       Seat seat =  reservation.getSeat();
       seat.setBooked(false);
       reservation.setStatus(ReservationStatus.CANCELLED);
       reservationRepository.save(reservation);
    }
    }


