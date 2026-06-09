package com.example.onlinemovieticketbookingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinemovieticketbookingsys.beans.ShowSeat;
import com.example.onlinemovieticketbookingsys.repository.Showseatrepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/user/showseat")
public class ShowSeatController {
	@Autowired
	private Showseatrepo repo;
	
	@GetMapping("/{showId}/seats")
	public List<ShowSeat> getSeats(@PathVariable int showId)
	{
//		return repo.findById(showId);
		return repo.findBySh_Id(showId);
	}

}
