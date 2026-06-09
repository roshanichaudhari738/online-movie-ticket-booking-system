package com.example.onlinemovieticketbookingsys.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinemovieticketbookingsys.beans.Screen;
import com.example.onlinemovieticketbookingsys.beans.Seat;
import com.example.onlinemovieticketbookingsys.exceptions.ScreenNotFoundException;
import com.example.onlinemovieticketbookingsys.repository.ScreenRepo;
import com.example.onlinemovieticketbookingsys.repository.SeatRepo;
import com.example.onlinemovieticketbookingsys.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	private SeatRepo repo;
	
	@Autowired
	private ScreenRepo screpo;
	
	@Override
	public List<Seat> generateSeats(Integer screenId) {
		Screen sc=screpo.findById(screenId).orElseThrow(() ->
		new ScreenNotFoundException("Screen not found with id "+screenId));
		
		List<Seat> seat=new ArrayList<>();
		
		for(int i=1;i<=sc.getTotalSeats();i++)
		{
			Seat s=new Seat();
			s.setSeatNumber(
					"A"+i);
			s.setIsBooked(false);
//			s.setSeatType(s.getSeatType());
			s.setScreen(sc);
			seat.add(s);
		}
		return repo.saveAll(seat);
	}

	@Override
	public List<Seat> getSeatsByScreen(Integer screenId) {
		// TODO Auto-generated method stub
		return repo.findBySeid(
                screenId
        );
	}

}
