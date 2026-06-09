package com.example.onlinemovieticketbookingsys.service;

import java.util.List;

import com.example.onlinemovieticketbookingsys.beans.Seat;

public interface SeatService {
	 List<Seat> generateSeats(
	            Integer screenId
	    );

	    List<Seat> getSeatsByScreen(
	            Integer screenId
	    );

}
