package com.example.onlinemovieticketbookingsys.dto;

import java.time.LocalTime;
import java.util.List;

import com.example.onlinemovieticketbookingsys.beans.BookingStatus;

public class BookingResponse {
	 	private int bookingId;
	    private String userName;
	    private String movieName;
	    private String showTime;
	    private Double amount;
	    private Double price;
	    private LocalTime bookingTime;
	    private long availableSeats;
	    private List<String> seatNumbers;
	    private BookingStatus status;
	    private String thName;
	    
		public int getBookingId() {
			return bookingId;
		}
		public void setBookingId(int bookingId) {
			this.bookingId = bookingId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getMovieName() {
			return movieName;
		}
		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
		public String getShowTime() {
			return showTime;
		}
		public void setShowTime(String showTime) {
			this.showTime = showTime;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		public LocalTime getBookingTime() {
			return bookingTime;
		}
		public void setBookingTime(LocalTime bookingTime) {
			this.bookingTime = bookingTime;
		}
		public List<String> getSeatNumbers() {
			return seatNumbers;
		}
		public void setSeatNumbers(List<String> seatNumbers) {
			this.seatNumbers = seatNumbers;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public long getAvailableSeats() {
			return availableSeats;
		}
		public void setAvailableSeats(long availableSeats) {
			this.availableSeats = availableSeats;
		}
		public BookingStatus getStatus() {
			return status;
		}
		public void setStatus(BookingStatus status) {
			this.status = status;
		}
		public String getThName() {
			return thName;
		}
		public void setThName(String thName) {
			this.thName = thName;
		}
	    
	    
	    
}
