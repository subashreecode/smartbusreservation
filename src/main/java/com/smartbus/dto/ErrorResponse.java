package com.smartbus.dto;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String message;
    private String error;
    private LocalDateTime timestamp;
    private int status;

    public ErrorResponse(String message,String error, int status)
    {
        this.message = message;
        this.error = error;
        this.status = status;
        this.timestamp = LocalDateTime.now();

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
