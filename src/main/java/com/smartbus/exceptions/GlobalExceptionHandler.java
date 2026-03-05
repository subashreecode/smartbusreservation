package com.smartbus.exceptions;

import com.smartbus.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
     public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex)
     {
         ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),
                 ex.getClass().getSimpleName(), HttpStatus.NOT_FOUND.value());
         return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
     }

     @ExceptionHandler(PaymentFailedException.class)
     public ResponseEntity<ErrorResponse> handlePaymentFailure(PaymentFailedException ex)
     {
         ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),ex.getClass().getSimpleName(),HttpStatus.PAYMENT_REQUIRED.value());
         return new ResponseEntity<>(errorResponse,HttpStatus.PAYMENT_REQUIRED);
     }

     @ExceptionHandler(SeatAlreadyBookedException.class)
     public ResponseEntity<ErrorResponse> handleSeatBooked(SeatAlreadyBookedException ex)
     {
         ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),ex.getClass().getSimpleName(),HttpStatus.BAD_REQUEST.value());
         return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

     }

     @ExceptionHandler(Exception.class)
     public ResponseEntity<ErrorResponse> handleGeneric(Exception ex)
     {
         ErrorResponse errorResponse= new ErrorResponse(ex.getMessage(),ex.getClass().
                 getSimpleName(),HttpStatus.INTERNAL_SERVER_ERROR.value());
         return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);

     }
}
