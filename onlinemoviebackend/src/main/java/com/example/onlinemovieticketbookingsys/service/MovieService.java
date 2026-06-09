package com.example.onlinemovieticketbookingsys.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.onlinemovieticketbookingsys.beans.Movie;

public interface MovieService {
	public Movie addMovie(Movie m,MultipartFile image) throws Exception;
	public List<Movie> getMovie();
	public Movie getByID(int id);
	List<Movie> getActivateMovie();
	
	
}
