package com.example.onlinemovieticketbookingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinemovieticketbookingsys.beans.Booking;
import com.example.onlinemovieticketbookingsys.dto.BookingPayment;
import com.example.onlinemovieticketbookingsys.dto.BookingRequest;
import com.example.onlinemovieticketbookingsys.dto.BookingResponse;
import com.example.onlinemovieticketbookingsys.repository.BookingRepo;
import com.example.onlinemovieticketbookingsys.serviceImpl.BookingServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/user/book")
public class BookingController {

	@Autowired
	private BookingRepo repo;
	
	@Autowired
	private BookingServiceImpl book;
	
	@PostMapping()
	public BookingResponse bookTicket(@RequestBody BookingRequest req)
	{
		return book.createBooking(req);
	}
	
	@GetMapping("/users/{userId}")
	public List<BookingResponse> getBookingByUserId(@PathVariable int userId)
	{
		return book.getBookingByUserId(userId);
	}
	
	@GetMapping("/get/{bookingId}")
	public BookingPayment getPaymentBookingDetail(@PathVariable int bookingId)
	{
		return book.getBookingDetails(bookingId);
	}
	
	
}
