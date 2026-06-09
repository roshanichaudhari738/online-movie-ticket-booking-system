package com.example.onlinemovieticketbookingsys.dto;

public class BookingPayment {
//	private int userId;
	private int bookingId;
	private double amount;
	
	
	
	public BookingPayment() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	
	
	
	public double getAmount() {
		return amount;
	}
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
