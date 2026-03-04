package com.smartbus.service;

import com.smartbus.model.Reservation;
import com.smartbus.model.ReservationStatus;
import com.smartbus.model.Seat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class BackgroundTaskService {

    Logger logger = Logger.getLogger(BackgroundTaskService.class.getName());
    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    public void runAsync(Runnable task)
    {
        executor.submit(task);
    }

    //seat auto‑released due to timeout.
    public void scheduleSeatAutoRelease(Seat seat, Reservation reservation)
    {
        executor.submit(()->
        {
            try
            {
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(reservation.getStatus()== ReservationStatus.PENDING)
            {
                seat.setBooked(false);
                reservation.setStatus(ReservationStatus.EXPIRED);
            }
        });
    }

    public void sendAsyncNotification(String message,String email)
    {
        executor.submit(()->
        {
            try
            {
                Thread.sleep(1000);//Simulate sending delay
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("Notification sent to " + email + ": " + message);

        });
    }

}
