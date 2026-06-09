package com.example.onlinemovieticketbookingsys.serviceImpl;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.onlinemovieticketbookingsys.beans.Booking;
import com.example.onlinemovieticketbookingsys.beans.BookingStatus;
import com.example.onlinemovieticketbookingsys.beans.Show;
import com.example.onlinemovieticketbookingsys.beans.ShowSeat;
import com.example.onlinemovieticketbookingsys.beans.User;
import com.example.onlinemovieticketbookingsys.dto.BookingPayment;
import com.example.onlinemovieticketbookingsys.dto.BookingRequest;
import com.example.onlinemovieticketbookingsys.dto.BookingResponse;
import com.example.onlinemovieticketbookingsys.exceptions.SeatAlreadyBookedException;
import com.example.onlinemovieticketbookingsys.exceptions.ShowNotFoundException;
import com.example.onlinemovieticketbookingsys.repository.BookingRepo;
import com.example.onlinemovieticketbookingsys.repository.ShowRepo;
import com.example.onlinemovieticketbookingsys.repository.Showseatrepo;
import com.example.onlinemovieticketbookingsys.repository.UserRepo;
import com.example.onlinemovieticketbookingsys.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private ShowRepo shrepo;
	
	@Autowired
	private BookingRepo brepo;
	
	@Autowired
	private Showseatrepo showsearrepo;
	
	@Override
	public BookingResponse createBooking(BookingRequest req) {
		User user=userrepo.findById(req.getUserId()).orElseThrow(() ->
		new UsernameNotFoundException("User not found with id "+ req.getUserId()));
		
		Show show=shrepo.findById(req.getShowId()).orElseThrow(() ->
		new ShowNotFoundException("show not found with id "+ req.getShowId()));
		
		List<ShowSeat> seats=showsearrepo.findAllById(req.getSeatId());
		
		if(seats.size() != req.getSeatId().size())
		{
		    throw new RuntimeException("Some seat ids are invalid");
		}
		
		System.out.println("User Id = " + req.getUserId());
		System.out.println("Show Id = " + req.getShowId());
		System.out.println("Seat Ids = " + req.getSeatId());
		//check the avalibility /already book for seat
		for (ShowSeat seat : seats) {
			if(seat.getBooked())
			{
				throw new SeatAlreadyBookedException("The seat already book with id "+ seat.getSeatNumber());
			}
		}
		
		
		double totalAmount=
				seats.size() * show.getPrice();
		
		System.out.println("Price = " + show.getPrice());
		System.out.println("Seats = " + seats.size());
		System.out.println("Total = " + totalAmount);
		
		for (ShowSeat seat : seats) {
			seat.setBooked(true); //the seat mark the true for booking
		}
		
		showsearrepo.saveAll(seats);
		System.out.println("Total show seats = " + show.getShowseat().size());
		long availableSeats =
		       showsearrepo.countBySh_IdAndBookedFalse(show.getId());
		
		System.out.println("Available Seats = " + availableSeats);
		
		Booking book=new Booking();
		book.setUser(user);
		book.setShow(show);
		book.setSeats(seats);
		book.setAmount(totalAmount);
		book.setBookingTime(LocalTime.now());
		book.setStatus(BookingStatus.BOOKED);
		Booking saveBooking= brepo.save(book);
		
		BookingResponse resp=new BookingResponse();
		resp.setBookingId(saveBooking.getId());
		resp.setUserName(saveBooking.getUser().getName());
		resp.setMovieName(saveBooking.getShow().getMovie().getTitle());
		resp.setShowTime(saveBooking.getShow().getShowTime());
		resp.setPrice(saveBooking.getShow().getPrice());
		resp.setAmount(saveBooking.getAmount());
		resp.setAvailableSeats(availableSeats);
		resp.setBookingTime(saveBooking.getBookingTime());
		resp.setStatus(saveBooking.getStatus());
		
		List<String> seatNum=
				saveBooking.getSeats().stream().map(ShowSeat :: getSeatNumber).toList();
		resp.setSeatNumbers(seatNum);
		
		return resp;
	}
	
	public BookingResponse getBookingAll(int id)
	{
		Booking book=brepo.findById(id).orElseThrow(() ->
        new RuntimeException("Booking not found"));
		
		BookingResponse resp=new BookingResponse();
		resp.setBookingId(book.getId());
		resp.setUserName(book.getUser().getName());
		resp.setMovieName(book.getShow().getMovie().getTitle());
		resp.setShowTime(book.getShow().getShowTime());
		resp.setPrice(book.getShow().getPrice());
		resp.setAmount(book.getAmount());
		resp.setBookingTime(book.getBookingTime());
		resp.setStatus(book.getStatus());
		long availableSeats =
		        showsearrepo.countBySh_IdAndBookedFalse(
		                book.getShow().getId());
		
		resp.setAvailableSeats(
	            availableSeats);
		
		List<String> seatNumbers =
	            book.getSeats()
	                   .stream()
	                   .map(ShowSeat::getSeatNumber)
	                   .toList();
		
		 resp.setSeatNumbers(
		            seatNumbers);
		 
		 return resp;
		
		
	}
	
	public List<BookingResponse> getBookingByUserId(int id)
	{
		List<Booking> book=brepo.findByUser_Id(id);
		
		return book.stream()
				.map(this::mapToResponse)
	            .toList();
	}
	
	//mapping method
	private BookingResponse mapToResponse(Booking booking)
	{
	    BookingResponse resp =
	            new BookingResponse();

	    resp.setBookingId(
	            booking.getId());

	    resp.setUserName(
	            booking.getUser().getName());

	    resp.setMovieName(
	            booking.getShow()
	                   .getMovie()
	                   .getTitle());

	    resp.setShowTime(
	            booking.getShow()
	                   .getShowTime());

	    resp.setPrice(
	            booking.getShow()
	                   .getPrice());

	    resp.setAmount(
	            booking.getAmount());

	    resp.setBookingTime(
	            booking.getBookingTime());

	    resp.setStatus(
	            booking.getStatus());

	    long availableSeats =
	        showsearrepo.countBySh_IdAndBookedFalse(
	                booking.getShow().getId());

	    resp.setAvailableSeats(
	            availableSeats);

	    List<String> seatNumbers =
	            booking.getSeats()
	                   .stream()
	                   .map(ShowSeat::getSeatNumber)
	                   .toList();

	    resp.setSeatNumbers(
	            seatNumbers);
	    
	    resp.setThName(booking.getShow().getScreen().getTheatre().getName());

	    return resp;
	}
	
	
	public List<BookingResponse> getAllBooking()
	{
		List<Booking> booking=brepo.findAll();
		
		return booking.stream().map(book->{
		BookingResponse resp=new BookingResponse();
		resp.setBookingId(book.getId());
		resp.setUserName(book.getUser().getName());
		resp.setMovieName(book.getShow().getMovie().getTitle());
		resp.setShowTime(book.getShow().getShowTime());
		resp.setPrice(book.getShow().getPrice());
		resp.setAmount(book.getAmount());
		resp.setBookingTime(book.getBookingTime());
		resp.setStatus(book.getStatus());
		long availableSeats =
		        showsearrepo.countBySh_IdAndBookedFalse(
		                book.getShow().getId());
		
		resp.setAvailableSeats(
	            availableSeats);
		
		List<String> seatNumbers =
	            book.getSeats()
	                   .stream()
	                   .map(ShowSeat::getSeatNumber)
	                   .toList();
		
		 resp.setSeatNumbers(
		            seatNumbers);
		 
		 return resp;
		}).toList();
		
	}
	
	public BookingPayment getBookingDetails(int bid)
	{
		
		Booking book=brepo.findById(bid).orElseThrow(() -> 
		new RuntimeException("Booking not found with id "+bid));
		
		
		BookingPayment bookpay=new BookingPayment();
	
		bookpay.setBookingId(book.getId());
		bookpay.setAmount(book.getAmount());
		
		return bookpay;
		
		
	}

}
