package com.example.onlinemovieticketbookingsys.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String seatNumber;
	private Boolean booked=false;
	
	@JsonBackReference("show-seat")
	@ManyToOne
	@JoinColumn(name = "shid")
	private Show sh;
	
	public ShowSeat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowSeat(int id, String seatNumber, Boolean booked) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.booked = booked;
	}

	
	
	public Show getSh() {
		return sh;
	}

	public void setSh(Show sh) {
		this.sh = sh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Boolean getBooked() {
		return booked;
	}

	public void setBooked(Boolean booked) {
		this.booked = booked;
	}

	@Override
	public String toString() {
		return "ShowSeat [id=" + id + ", seatNumber=" + seatNumber + ", booked=" + booked + "]";
	}
	
	
	
	
}
