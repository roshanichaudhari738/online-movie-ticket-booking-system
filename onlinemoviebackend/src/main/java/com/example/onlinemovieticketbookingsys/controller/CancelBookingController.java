package com.example.onlinemovieticketbookingsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinemovieticketbookingsys.dto.CancelBookingResponse;
import com.example.onlinemovieticketbookingsys.serviceImpl.CancelBookingServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/user/cancel")
public class CancelBookingController {
	
	@Autowired
	private CancelBookingServiceImpl cancel;
	
	@PutMapping("/{bookingId}")
	public CancelBookingResponse cancelBook(@PathVariable int bookingId)
	{
		return cancel.cancelBooking(bookingId);
	}

}
