package com.example.onlinemovieticketbookingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinemovieticketbookingsys.beans.Movie;
import com.example.onlinemovieticketbookingsys.beans.Theatre;
import com.example.onlinemovieticketbookingsys.serviceImpl.TheaterServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/theater")
public class TheaterController {
	
	@Autowired
	private TheaterServiceImpl theater;

	@GetMapping("/all")
	public List<Theatre> getAllTheater()
	{
		return theater.getAllTheater();
	}

	
	@GetMapping("/get/{id}")
	public Theatre getMovieById(@PathVariable int id)
	{
		return theater.getTheaterById(id);
	}
}
