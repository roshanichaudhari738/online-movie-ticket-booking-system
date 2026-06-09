package com.example.onlinemovieticketbookingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinemovieticketbookingsys.beans.Seat;
import com.example.onlinemovieticketbookingsys.serviceImpl.SeatServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/seat")
public class SeatController {
	
	@Autowired
	private SeatServiceImpl seat;
	
	@GetMapping("/{scid}")
	public List<Seat> getSecreenById(@PathVariable int scid)
	{
		return seat.getSeatsByScreen(scid);
	}

}
