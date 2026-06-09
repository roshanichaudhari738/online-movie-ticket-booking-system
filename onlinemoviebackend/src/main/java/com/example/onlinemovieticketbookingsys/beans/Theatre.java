package com.example.onlinemovieticketbookingsys.beans;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatre_table")
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String name;
	private String location;
	private boolean active = true;
	
	@OneToMany(
			mappedBy = "theatre",
			cascade = CascadeType.ALL
			)
	@JsonManagedReference("screen-theatre")
	private List<Screen> screens;
	
	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Theatre(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public int getId() {
		return tid;
	}

	public void setId(int id) {
		this.tid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}
	
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tid, location, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatre other = (Theatre) obj;
		return tid == other.tid && Objects.equals(location, other.location) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Theatre [id=" + tid + ", name=" + name + ", location=" + location + "]";
	}
	
}
