package com.example.onlinemovieticketbookingsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinemovieticketbookingsys.beans.Booking;
import com.example.onlinemovieticketbookingsys.dto.BookingResponse;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
		List<Booking> findByUser_Id(int id);

}
