package com.example.onlinemovieticketbookingsys.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinemovieticketbookingsys.beans.Screen;
import com.example.onlinemovieticketbookingsys.beans.Theatre;
import com.example.onlinemovieticketbookingsys.exceptions.TheatreNotFoundException;
import com.example.onlinemovieticketbookingsys.repository.TheatreRepository;
import com.example.onlinemovieticketbookingsys.service.TheatreService;

@Service
public class TheaterServiceImpl implements TheatreService {

	@Autowired
	private TheatreRepository repo;
	
	@Override
	public Theatre addTheater(Theatre t) {
		
		return repo.save(t);
	}

	@Override
	public List<Theatre> getAllTheater() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Theatre getTheaterById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new TheatreNotFoundException("Theatre Not Found : "+id));
	}


	@Override
	public void deleteTheaterById(int id) {
		
		 repo.deleteById(id);;
	}
	
	public Theatre deactivateTheatre(int id)
	{
		Theatre sc=repo.findById(id).orElseThrow();
		
		sc.setActive(!sc.isActive());
		return repo.save(sc);
	}

}
