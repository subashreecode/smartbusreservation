package com.smartbus.service;

import com.smartbus.dto.ReservationResponseDTO;
import com.smartbus.exceptions.ResourceNotFoundException;
import com.smartbus.exceptions.SeatAlreadyBookedException;
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

    @Autowired
    private PaymentSimulationService paymentSimulationService;

    @Autowired
    private BackgroundTaskService backgroundTaskService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DtoMapper dtoMapper;



    public ReservationResponseDTO reserveSeat(Long busId, Long seatId, Long userId, LocalDate journeyDate)
    {
        Bus bus = busRepository.findById(busId).
                orElseThrow(()->new ResourceNotFoundException("Bus not found"));
        Seat seat = seatRepository.findById(seatId).
                orElseThrow(()->new ResourceNotFoundException("Seat not found"));
        User user = userRepository.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User not found"));
         validateSeatAvailability(seat,journeyDate);
         //seat.setBooked(true);
         Reservation reservation = new Reservation();
         reservation.setBus(bus);
         reservation.setSeat(seat);
         reservation.setUser(user);
         reservation.setJourneyDate(journeyDate);
         reservation.setBookingTime(LocalDateTime.now());
         reservation.setStatus(ReservationStatus.PAYMENT_PENDING);
         reservationRepository.save(reservation);
        backgroundTaskService.scheduleSeatAutoRelease(seat, reservation);

        backgroundTaskService.sendAsyncNotification(
                "Your reservation is pending payment.",
                user.getEmail());

        boolean paymentSuccess = paymentSimulationService.processPayment(reservation.getId());
        if(paymentSuccess)
        {
            reservation.setStatus(ReservationStatus.BOOKED);
            seat.setBooked(true);
            backgroundTaskService.sendAsyncNotification(
                    "Payment successful! Your seat is booked.",
                    user.getEmail()
            );
        }
        else
        {
            reservation.setStatus(ReservationStatus.PAYMENT_FAILED);
            seat.setBooked(false);
            backgroundTaskService.sendAsyncNotification(
                    "Payment failed. Your seat has been released.",
                    user.getEmail());

        }
        return dtoMapper.toReservationDTO(reservationRepository.save(reservation));
    }

    private void validateSeatAvailability(Seat seat, LocalDate date) {
        if (Boolean.TRUE.equals(seat.getBooked())) {
            throw new SeatAlreadyBookedException("Seat already booked");
        }
        boolean exists = reservationRepository.existsBySeatIdAndJourneyDate(seat.getId(), date);
        if (exists) {
            throw new SeatAlreadyBookedException("Seat already reserved for this date");
        }
    }
    public void cancelReservation(Long reservationId)
    {
       Reservation reservation = reservationRepository.findById(reservationId).
               orElseThrow(()->new ResourceNotFoundException("Reservation not found"));
       Seat seat =  reservation.getSeat();
       seat.setBooked(false);
       reservation.setStatus(ReservationStatus.CANCELLED);
       reservationRepository.save(reservation);
       backgroundTaskService.sendAsyncNotification("Your reservation has been cancelled.",
               reservation.getUser().getEmail());
    }

    public Reservation getReservationById(Long id) {

        return reservationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Reservation not found"));
    }
}

