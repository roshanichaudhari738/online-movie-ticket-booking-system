package com.example.onlinemovieticketbookingsys.beans;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_table")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	
	@ManyToOne()
	@JoinColumn(name = "id")
	@JsonBackReference("user-booking")
	private User user;
	
	@JsonBackReference("show-booking")
	@ManyToOne()
	@JoinColumn(name = "shid")
	private Show show;
	
	private Double amount;
	private LocalTime bookingTime;
	
	@ManyToMany()
	@JoinTable(
			name = "booking_showseat",
			joinColumns=
			@JoinColumn(name = "booking_id"),
			inverseJoinColumns = 
			@JoinColumn(name= "showseat_id")
			)
	private List<ShowSeat> seats;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus status;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int id, User user, Show show, Double amount, LocalTime bookingTime) {
		super();
		this.bid = id;
		this.user = user;
		this.show = show;
		this.amount = amount;
		this.bookingTime = bookingTime;
	}

	
	
	
	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public List<ShowSeat> getSeats() {
		return seats;
	}

	public void setSeats(List<ShowSeat> seats) {
		this.seats = seats;
	}

	public int getId() {
		return bid;
	}

	public void setId(int id) {
		this.bid = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
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

	@Override
	public int hashCode() {
		return Objects.hash(amount, bookingTime, bid, show, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(bookingTime, other.bookingTime) && bid == other.bid
				&& Objects.equals(show, other.show) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Booking [id=" + bid + ", user=" + user + ", show=" + show + ", amount=" + amount + ", bookingTime="
				+ bookingTime + "]";
	}

	
}
