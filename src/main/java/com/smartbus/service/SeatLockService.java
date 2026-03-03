package com.smartbus.service;

import com.smartbus.model.Seat;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class SeatLockService {
    Logger logger = Logger.getLogger(SeatLockService.class.getName());

    public void lockSeat(Seat seat)
    {
        logger.info("Inside method before change:"+seat.getBooked());
        // Modify the object → original reference sees this

        seat.setBooked(true);
        logger.info("Inside method after change:"+seat.getBooked());
        // Reassign the parameter → original reference does NOT see this
        seat = new Seat();
        seat.setBooked(false);
        logger.info("Inside method after reassign:"+seat.getBooked());

    }
    /*Before calling method: false
    Inside method BEFORE change: false
    Inside method AFTER change: true
    Inside method AFTER reassign: false
    After calling method: true*/

}
