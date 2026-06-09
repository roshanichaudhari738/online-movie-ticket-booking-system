package com.example.onlinemovieticketbookingsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinemovieticketbookingsys.beans.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer> {
	List<Seat> findBySeid(
            Integer scid
    );
}
