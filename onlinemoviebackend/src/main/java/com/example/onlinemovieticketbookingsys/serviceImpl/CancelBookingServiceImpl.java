package com.example.onlinemovieticketbookingsys.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinemovieticketbookingsys.beans.Booking;
import com.example.onlinemovieticketbookingsys.beans.BookingStatus;
import com.example.onlinemovieticketbookingsys.beans.ShowSeat;
import com.example.onlinemovieticketbookingsys.dto.CancelBookingResponse;
import com.example.onlinemovieticketbookingsys.repository.BookingRepo;
import com.example.onlinemovieticketbookingsys.repository.Showseatrepo;
import com.example.onlinemovieticketbookingsys.service.CancelBookingService;

@Service
public class CancelBookingServiceImpl implements CancelBookingService {

	@Autowired
	private BookingRepo repo;
	
	@Autowired
	private Showseatrepo shrepo;
	@Override
	public CancelBookingResponse cancelBooking(int bookid) {
		Booking book=repo.findById(bookid).orElseThrow(() ->
        new RuntimeException("Booking not found"));
		if(book.getStatus() == BookingStatus.CANCELLED)
		{
		    throw new RuntimeException(
		        "Booking already cancelled");
		}
		book.setStatus(BookingStatus.CANCELLED);
		
		
		for (ShowSeat  seats: book.getSeats()) {
			seats.setBooked(false);
		}
		shrepo.saveAll(book.getSeats());
		 repo.save(book);
		 
		 long availableSeats =
				    shrepo.countBySh_IdAndBookedFalse(
				        book.getShow().getId()
				    );
		 CancelBookingResponse resp=new CancelBookingResponse();
		 resp.setBookingId(book.getId());
		 resp.setStatus(book.getStatus());
		 resp.setAvailableSeats(availableSeats);
		 resp.setMessage("Booking cancelled successfully");
		 
		 return resp;
		 
	}

}
