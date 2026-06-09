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
@Table(name = "screen_table")
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scid;
	private String name;
	private int totalSeats;
	 private boolean active = true;
	
	@ManyToOne
	@JoinColumn(name = "tid")
	@JsonBackReference("screen-theatre")
	private Theatre theatre;
	
	@JsonManagedReference("screen-show")
	@OneToMany(mappedBy = "screen",
			cascade = CascadeType.ALL)
	private List<Show> show;
	
	@OneToMany(mappedBy = "screen",
			cascade = CascadeType.ALL)
	private List<Seat> seat;
	
	public Screen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Screen(String name, int totalSeats) {
		super();
		this.name = name;
		this.totalSeats = totalSeats;
	}

	
	
	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public int getId() {
		return scid;
	}

	public void setId(int id) {
		this.scid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(scid, name, totalSeats);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		return scid == other.scid && Objects.equals(name, other.name) && totalSeats == other.totalSeats;
	}

	@Override
	public String toString() {
		return "Screen [id=" + scid + ", name=" + name + ", totalSeats=" + totalSeats + "]";
	}
	

}
