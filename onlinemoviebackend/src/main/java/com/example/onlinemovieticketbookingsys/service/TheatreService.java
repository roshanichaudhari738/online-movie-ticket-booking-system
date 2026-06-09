package com.example.onlinemovieticketbookingsys.service;

import java.util.List;

import com.example.onlinemovieticketbookingsys.beans.Theatre;

public interface TheatreService {
	public Theatre addTheater(Theatre t);
	public List<Theatre> getAllTheater();
	public Theatre getTheaterById(int id);
	
	public void deleteTheaterById(int id);
	

}
