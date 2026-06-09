package com.example.onlinemovieticketbookingsys.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class ErrorResponse {
	private int statusCode;
    private String message;

    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    // Getters
    public int getStatusCode() { return statusCode; }
    public String getMessage() { return message; }

}
