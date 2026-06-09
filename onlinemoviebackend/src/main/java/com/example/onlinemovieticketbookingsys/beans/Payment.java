package com.example.onlinemovieticketbookingsys.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
	
	@Id
    @GeneratedValue(
            strategy =
            GenerationType.IDENTITY
    )
    private Integer id;

    private Double amount;

    private String paymentMethod;

    private String transactionId;

    private String status;
    private String msg; 

    @OneToOne
    private Booking booking;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Integer id, Double amount, String paymentMethod, String transactionId, String status,
			Booking booking) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.transactionId = transactionId;
		this.status = status;
		this.booking = booking;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", transactionId="
				+ transactionId + ", status=" + status + ", booking=" + booking + "]";
	}
    
    

}
