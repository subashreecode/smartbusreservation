package com.smartbus.exceptions;

import com.smartbus.model.Reservation;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
