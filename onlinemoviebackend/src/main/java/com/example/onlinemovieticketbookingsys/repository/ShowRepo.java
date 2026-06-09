package com.example.onlinemovieticketbookingsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinemovieticketbookingsys.beans.Show;

public interface ShowRepo extends JpaRepository<Show, Integer> {
	List<Show> findByMovieId(int movieId);
	List<Show> findByActiveTrue();
	List<Show> findByMovieIdAndActiveTrueAndScreenActiveTrueAndScreenTheatreActiveTrue(int movieId);
}
