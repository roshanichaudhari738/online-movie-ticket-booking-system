package com.example.onlinemovieticketbookingsys.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinemovieticketbookingsys.beans.Screen;
import com.example.onlinemovieticketbookingsys.beans.Theatre;
import com.example.onlinemovieticketbookingsys.exceptions.ScreenNotFoundException;
import com.example.onlinemovieticketbookingsys.exceptions.TheatreNotFoundException;
import com.example.onlinemovieticketbookingsys.repository.ScreenRepo;
import com.example.onlinemovieticketbookingsys.repository.TheatreRepository;
import com.example.onlinemovieticketbookingsys.service.ScreenService;

@Service
public class ScreenServiceImpl implements ScreenService {

	@Autowired
	private ScreenRepo repo;
	
	@Autowired
	private TheatreRepository repoth;
	
	@Override
	public Screen addScreen(int tid, Screen sc) {
		Theatre t=repoth.findById(tid).orElseThrow(()->
		new TheatreNotFoundException("Theater not found with id "+tid));
		
		sc.setTheatre(t);
		return repo.save(sc);
	}

	@Override
	public List<Screen> getAllScreen() {
		
		return repo.findAll();
	}

	@Override
	public Screen getScreenById(int id) {
		
		return repo.findById(id).orElseThrow(() ->
		new ScreenNotFoundException("Screen not found with id "+id));
	}
	
	public Screen deactivateScreen(int id)
	{
		Screen sc=repo.findById(id).orElseThrow();
		
		sc.setActive(!sc.isActive());
		return repo.save(sc);
	}

}
