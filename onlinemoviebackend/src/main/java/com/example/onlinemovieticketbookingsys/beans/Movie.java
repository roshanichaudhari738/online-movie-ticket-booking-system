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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie_table")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	private String title;
	private String genre;
	private String language;
	private int duration;
	private Double rating;
	private String imageName;
	private boolean active = true;
	
	@JsonManagedReference("movie-shows")
	@OneToMany(
			mappedBy = "movie",
			cascade = CascadeType.ALL
			)
	private List<Show> shows;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String genre, String language, int duration,Double rating,String imageName) {
		super();
		this.title = title;
		this.genre = genre;
		this.language = language;
		this.duration = duration;
		this.rating=rating;
		this.imageName=imageName;
	}

	public int getId() {
		return mid;
	}

	public void setId(int id) {
		this.mid = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duration, genre, mid, language, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return duration == other.duration && Objects.equals(genre, other.genre) && mid == other.mid
				&& Objects.equals(language, other.language) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Movie [id=" + mid + ", title=" + title + ", genre=" + genre + ", language=" + language + ", duration="
				+ duration + "]";
	}
	
	

}
