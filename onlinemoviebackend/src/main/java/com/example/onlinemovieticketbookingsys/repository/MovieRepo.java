package com.example.onlinemovieticketbookingsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinemovieticketbookingsys.beans.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
	List<Movie> findByActiveTrue();

}
