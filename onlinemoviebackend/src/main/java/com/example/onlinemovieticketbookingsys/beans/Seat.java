package com.example.onlinemovieticketbookingsys.beans;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seat_table")
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seid;
	private String seatNumber;
//	private String seatType;
	private Boolean isBooked;
	
	@ManyToOne
	@JoinColumn(name = "scid")
	private Screen screen;
	
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(String seatNumber, String seatType, Boolean isBooked) {
		super();
		this.seatNumber = seatNumber;
//		this.seatType = seatType;
		this.isBooked = isBooked;
	}
	
	

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public int getId() {
		return seid;
	}

	public void setId(int id) {
		this.seid = id;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

//	public String getSeatType() {
//		return seatType;
//	}
//
//	public void setSeatType(String seatType) {
//		this.seatType = seatType;
//	}

	public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

	@Override
	public int hashCode() {
		return Objects.hash(seid, isBooked, seatNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return seid == other.seid && Objects.equals(isBooked, other.isBooked) && seatNumber == other.seatNumber
				;
	}

	@Override
	public String toString() {
		return "Seat [id=" + seid + ", seatNumber=" + seatNumber +  ", isBooked=" + isBooked
				+ "]";
	}
	
}
