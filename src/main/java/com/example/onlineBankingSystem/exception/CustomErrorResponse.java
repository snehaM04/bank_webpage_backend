package com.example.onlineBankingSystem.exception;

import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class CustomErrorResponse {
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomErrorResponse(HttpStatus status, String message, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

}
