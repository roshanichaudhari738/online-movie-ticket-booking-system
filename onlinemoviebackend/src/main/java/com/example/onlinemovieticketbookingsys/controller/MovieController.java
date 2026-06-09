package com.example.onlinemovieticketbookingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinemovieticketbookingsys.beans.Movie;
import com.example.onlinemovieticketbookingsys.serviceImpl.MovieServieImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class MovieController {

	@Autowired
	private MovieServieImpl movie;
	
	@GetMapping("/all")
	public List<Movie> getAllMovie()
	{
		return movie.getActivateMovie();
	}
	
	@GetMapping("/get/{id}")
	public Movie getMovieById(@PathVariable int id)
	{
		return movie.getByID(id);
	}
	
	
}
