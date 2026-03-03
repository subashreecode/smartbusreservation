package com.smartbus.repository;

import com.smartbus.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    boolean existsBySeatIdAndJourneyDate(Long seatId, LocalDate date);
}
