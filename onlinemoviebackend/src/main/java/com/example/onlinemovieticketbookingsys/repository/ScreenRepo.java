package com.example.onlinemovieticketbookingsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinemovieticketbookingsys.beans.Screen;

public interface ScreenRepo extends JpaRepository<Screen, Integer> {
	List<Screen> findByActiveTrue();

}
