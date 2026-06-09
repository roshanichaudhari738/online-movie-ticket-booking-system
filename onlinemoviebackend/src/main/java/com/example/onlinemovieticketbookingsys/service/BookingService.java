package com.example.onlinemovieticketbookingsys.service;

import com.example.onlinemovieticketbookingsys.dto.BookingRequest;
import com.example.onlinemovieticketbookingsys.dto.BookingResponse;

public interface BookingService {
	
	public BookingResponse createBooking(BookingRequest req);
}
