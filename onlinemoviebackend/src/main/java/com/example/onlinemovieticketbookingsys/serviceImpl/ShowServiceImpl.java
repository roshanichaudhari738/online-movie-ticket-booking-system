package com.example.onlinemovieticketbookingsys.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinemovieticketbookingsys.beans.Movie;
import com.example.onlinemovieticketbookingsys.beans.Screen;
import com.example.onlinemovieticketbookingsys.beans.Show;
import com.example.onlinemovieticketbookingsys.beans.ShowSeat;
import com.example.onlinemovieticketbookingsys.dto.ShowResponse;
import com.example.onlinemovieticketbookingsys.exceptions.MovieNotFoundException;
import com.example.onlinemovieticketbookingsys.exceptions.ScreenNotFoundException;
import com.example.onlinemovieticketbookingsys.exceptions.ShowNotFoundException;
import com.example.onlinemovieticketbookingsys.repository.MovieRepo;
import com.example.onlinemovieticketbookingsys.repository.ScreenRepo;
import com.example.onlinemovieticketbookingsys.repository.ShowRepo;
import com.example.onlinemovieticketbookingsys.repository.Showseatrepo;
import com.example.onlinemovieticketbookingsys.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {
	@Autowired
	private ShowRepo repo;
	
	@Autowired
	private MovieRepo mrepo;
	
	@Autowired
	private ScreenRepo screpo;
	
	@Autowired
	private Showseatrepo shrepo;

	@Override
	public Show addShow(int mid, int scid, Show show) {
		Movie m=mrepo.findById(mid).orElseThrow(() ->
		new MovieNotFoundException("Movie not found with id ",mid));
		
		Screen sc=screpo.findById(scid).orElseThrow(() ->
		new ScreenNotFoundException("Screen not found with id"+scid));
		
		
		
		show.setMovie(m);
		show.setScreen(sc);
//		return repo.save(show);
		Show savedShow = repo.save(show);
		
		List<ShowSeat> seats =
		        new ArrayList<>();

		for(int i=1;
		    i<=sc.getTotalSeats();
		    i++)
		{
		    ShowSeat seat =
		            new ShowSeat();

		    seat.setSeatNumber(
		            "S"+i
		    );

		    seat.setBooked(false);

		    seat.setSh(savedShow);

		    seats.add(seat);
		}

		shrepo.saveAll(seats);
		
		savedShow.setShowseat(seats);

		return savedShow;
	}

	@Override
	public List<Show> getAllShow() {
		
		return repo.findAll();
	}

	@Override
	public List<ShowResponse> getShowById(int id) {
		
		List<Show> shows=repo.findByMovieIdAndActiveTrueAndScreenActiveTrueAndScreenTheatreActiveTrue(id);
		
		return shows.stream().map(show -> {
			ShowResponse res=new ShowResponse();
			res.setId(show.getId());
			res.setShowTime(show.getShowTime());
			res.setPrice(show.getPrice());
			res.setMovieId(show.getMovie().getId());
			res.setScreenId(show.getScreen().getId());
			res.setScreenName(show.getScreen().getName());
			res.setTid(show.getScreen().getTheatre().getId());
			res.setThname(show.getScreen().getTheatre().getName());
			return res;
			
		}).toList();
	}
	
	public Show deactivateShow(int id)
	{
		Show sh=repo.findById(id).orElseThrow();
		sh.setActive(!sh.isActive());
		return repo.save(sh);
		
	}
	
//	public List<Show> getActiveShows()
//	{
//	    return repo.findByActiveTrue();
//	}
	
//	 public List<Show> getAvailableShows() {
//
//	        return repo.findByActiveTrueAndScreenActiveTrue();
//	    }
	
	
}
