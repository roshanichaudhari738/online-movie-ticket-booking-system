package com.example.onlinemovieticketbookingsys.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.onlinemovieticketbookingsys.beans.Movie;
import com.example.onlinemovieticketbookingsys.beans.Screen;
import com.example.onlinemovieticketbookingsys.beans.Seat;
import com.example.onlinemovieticketbookingsys.beans.Show;
import com.example.onlinemovieticketbookingsys.beans.Theatre;
import com.example.onlinemovieticketbookingsys.dto.BookingResponse;
import com.example.onlinemovieticketbookingsys.serviceImpl.BookingServiceImpl;
import com.example.onlinemovieticketbookingsys.serviceImpl.MovieServieImpl;
import com.example.onlinemovieticketbookingsys.serviceImpl.ScreenServiceImpl;
import com.example.onlinemovieticketbookingsys.serviceImpl.SeatServiceImpl;
import com.example.onlinemovieticketbookingsys.serviceImpl.ShowServiceImpl;
import com.example.onlinemovieticketbookingsys.serviceImpl.TheaterServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {
		
	@Autowired
	private MovieServieImpl movie;
	
	@Autowired
	private TheaterServiceImpl theater;
	
	@Autowired
	private ScreenServiceImpl screen;
	
	@Autowired
	private ShowServiceImpl show;
	
	@Autowired
	private SeatServiceImpl seat;
	
	@Autowired
	private BookingServiceImpl book;
	
	@PostMapping(value = "/add/movies",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String addMovie(@RequestParam String title,
	        @RequestParam String genre,
	        @RequestParam String language,
	        @RequestParam int duration,
	        @RequestParam Double rating,
	        @RequestParam MultipartFile image) throws Exception
	{
		Movie m = new Movie();
	    m.setTitle(title);
	    m.setGenre(genre);
	    m.setLanguage(language);
	    m.setDuration(duration);
	    m.setRating(rating);
		movie.addMovie(m,image);
		return "Movie record are saved !!";
	}
	
	@PutMapping(value = "/movies/{movieId}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)	
	public String updateMovie(@PathVariable int movieId,@ModelAttribute Movie m,
			@RequestParam(required = false) MultipartFile image) throws Exception
	{
		m.setId(movieId);
		movie.addMovie(m,image);
		return "Movie record are update !!!";
	}
	
//	@DeleteMapping("/movies/{movieId}")
//	public String deleteMovieById(@PathVariable int movieId)
//	{
//		movie.deletMovie(movieId);
//		return "Delete the movie!!!";
//	}
	
	@PutMapping("/movies/{movieId}")
	public String deactivateMovie(@PathVariable int movieId)
	{
		 movie.deactivateMovie(movieId);
		 return "theater Deactivated";
	}
	
	@GetMapping("/get/movies/{movieId}")
	public Movie getMovieById(@PathVariable int movieId)
	{
		return movie.getByID(movieId);
	}
	
	@PostMapping("/add/theatres")
	public Theatre addTheater(@RequestBody Theatre t)
	{
		return theater.addTheater(t);
	}
	
	@GetMapping("/movies")
	public List<Movie> getAllAdminMovie()
	{
		System.out.println("Get API call");
		return movie.getMovie();
	}
	
	@GetMapping("/theatres")
	public List<Theatre> getAllTheater()
	{
		return theater.getAllTheater();
	}
	
	@PutMapping("/updateTh/{id}")
	public String updateTheaterById(@PathVariable int id , @RequestBody Theatre t)
	{
		t.setId(id);
		theater.addTheater(t);
		return "Update the theater record !!!!";
	}
	
//	@DeleteMapping("/theatres/{id}")
//	public String deleteTheaterById(@PathVariable int id)
//	{
//		theater.deleteTheaterById(id);
//		return "Delete the Theater record !!!";
//	}
	
	@PutMapping("/theatres/{id}")
	public String deactivateTheatre(@PathVariable int id)
	{
		 theater.deactivateTheatre(id);
		 return "theater Deactivated";
	}
	
	@PostMapping("/theater/{theatreId}/screens")
	public Screen addScreen(@RequestBody Screen sc,@PathVariable int theatreId)
	{
		return screen.addScreen(theatreId, sc);
	}
	
	@PutMapping("/screens/{id}")
	public String deactivateScreen(@PathVariable int id)
	{
		screen.deactivateScreen(id);
		return "Screen Deactivated";
	}
	
	@GetMapping("/screens")
	public List<Screen> getAllAdminScreen()
	{
		System.out.println("Get API call");
		return screen.getAllScreen();
	}
	
	@PostMapping("/movie/{movieId}/screen/{screenId}/show")
	public Show addShow(@PathVariable int movieId , 
			@PathVariable int screenId , 
			@RequestBody Show sh)
	{
		return show.addShow(movieId, screenId, sh);
	}
	
	@GetMapping("/shows")
	public List<Show> getAllShow()
	{
		return show.getAllShow();
	}
	
	@PutMapping("/shows/{id}")
	public String deactivateShow(@PathVariable int id)
	{
		 show.deactivateShow(id);
		 return "Show Deactivated";
	}
	
	@PostMapping("/screens/{scid}/seats")
	public List<Seat> generateSeats(@PathVariable int scid)
	{
		return seat.generateSeats(scid);
	}
	
	@GetMapping("/bookings")
	public List<BookingResponse> getAllUserBooking()
	{
		return book.getAllBooking();
	}
}
