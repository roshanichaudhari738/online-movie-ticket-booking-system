package com.example.onlinemovieticketbookingsys.dto;

public class PaymentRequest {
	private Integer bookingId;

    private String paymentMethod;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
    
    

}
