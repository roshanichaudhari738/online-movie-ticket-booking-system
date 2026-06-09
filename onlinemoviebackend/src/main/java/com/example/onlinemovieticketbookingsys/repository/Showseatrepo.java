package com.example.onlinemovieticketbookingsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinemovieticketbookingsys.beans.Show;
import com.example.onlinemovieticketbookingsys.beans.ShowSeat;
import java.util.List;


public interface Showseatrepo extends JpaRepository<ShowSeat, Integer> {

	List<ShowSeat> findById(int id);
	Long countBySh_IdAndBookedFalse(int id);
	List<ShowSeat> findBySh_Id(int showId);
	
}
