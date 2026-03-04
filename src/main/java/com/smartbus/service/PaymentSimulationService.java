package com.smartbus.service;


import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PaymentSimulationService {
    Logger logger = Logger.getLogger(PaymentSimulationService.class.getName());

    public boolean processPayment(Long reservationId)
    {
        Thread thread = new Thread(()->
        {
            try{
                logger.info("Processing Payment for reservation {}"+reservationId);
                Thread.sleep(3000);
                logger.info("Completed Payment for reservation {}"+reservationId);

        }
        catch (InterruptedException  e)
        {
           throw new RuntimeException(e);
        }
        });
        thread.start();
        try
        {
            thread.join();//wait for thread to finish
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new java.util.Random().nextBoolean();
    }
}
