package com.example.onlinemovieticketbookingsys.dto;

import com.example.onlinemovieticketbookingsys.beans.BookingStatus;

public class CancelBookingResponse {
	private int bookingId;
    private BookingStatus status;
    private String message;
    private Long availableSeats;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(Long availableSeats) {
		this.availableSeats = availableSeats;
	}
    
    
}
