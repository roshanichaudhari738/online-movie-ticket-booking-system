package com.example.onlinemovieticketbookingsys.beans;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "show_table")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shid;
	private String showTime;
	private double price;
	 private boolean active = true;
	
	@JsonBackReference("movie-shows")
	@ManyToOne()
	@JoinColumn(name = "mid")
	private Movie movie;
	
	@JsonBackReference("screen-show")
	@ManyToOne()
	@JoinColumn(name = "scid")
	private Screen screen;
	
	@JsonManagedReference("show-seat")
	@OneToMany(
			mappedBy = "sh",
			cascade = CascadeType.ALL
			)
	private List<ShowSeat> showseat;
	
	@JsonManagedReference("show-booking")
	@OneToMany(
			mappedBy = "show",
			cascade = CascadeType.ALL)
	private List<Booking> booking;
	
	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Show(String showTime, double price, Movie movie, Screen screen) {
		super();
		this.showTime = showTime;
		this.price = price;
		this.movie = movie;
		this.screen = screen;
	}
	
	
	

	public List<ShowSeat> getShowseat() {
		return showseat;
	}

	public void setShowseat(List<ShowSeat> showseat) {
		this.showseat = showseat;
	}

	public int getId() {
		return shid;
	}

	public void setId(int id) {
		this.shid = id;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(shid, movie, price, screen, showTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Show other = (Show) obj;
		return shid == other.shid && Objects.equals(movie, other.movie)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(screen, other.screen) && showTime == other.showTime;
	}

	@Override
	public String toString() {
		return "Show [id=" + shid + ", showTime=" + showTime + ", price=" + price + ", movie=" + movie + ", screen="
				+ screen + "]";
	}

}
