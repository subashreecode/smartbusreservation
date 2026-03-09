package com.smartbus.controller;

import com.smartbus.dto.ReservationResponseDTO;
import com.smartbus.model.Reservation;
import com.smartbus.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    @PostMapping("/reserve")
    public ReservationResponseDTO reserveSeat(@RequestParam Long busId,
                                              @RequestParam Long seatId,
                                              @RequestParam Long userId,
                                              @RequestParam LocalDate journeyDate)
    {
       return reservationService.reserveSeat(busId, seatId, userId, journeyDate);
    }


    @PostMapping("/cancel/{id}")
    public String cancelReservation(@PathVariable Long id)
    {
        reservationService.cancelReservation(id);
        return "Reservation cancelled successfully";
    }

    @GetMapping("{id}")
    public Reservation viewReservation(@PathVariable Long id)
    {
        return reservationService.getReservationById(id);
    }

}
