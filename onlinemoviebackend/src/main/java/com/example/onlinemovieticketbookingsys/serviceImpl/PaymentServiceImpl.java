package com.example.onlinemovieticketbookingsys.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinemovieticketbookingsys.beans.Booking;
import com.example.onlinemovieticketbookingsys.beans.Payment;
import com.example.onlinemovieticketbookingsys.dto.PaymentRequest;
import com.example.onlinemovieticketbookingsys.dto.PaymentResponse;
import com.example.onlinemovieticketbookingsys.repository.BookingRepo;
import com.example.onlinemovieticketbookingsys.repository.PaymentRepo;
import com.example.onlinemovieticketbookingsys.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private BookingRepo bookingRepo;
	
	@Autowired
	private PaymentRepo repo;
	
	@Override
	public PaymentResponse makePayment(PaymentRequest request) {
		Booking booking =
	            bookingRepo.findById(
	                    request.getBookingId()
	            ).orElseThrow(()-> new RuntimeException("Booking record not foune!!"));

		System.out.println("Booking Id "+request.getBookingId());
	    Payment payment =
	            new Payment();

	    payment.setBooking(
	            booking
	    );

	    payment.setAmount(
	            booking.getAmount()
	    );

	    payment.setPaymentMethod(
	            request.getPaymentMethod()
	    );

	    payment.setTransactionId(
	            UUID.randomUUID()
	                    .toString()
	    );

	    payment.setStatus(
	            "SUCCESS"
	    );
	    
	    payment.setMsg("Payment Successful");
		 repo.save(payment);
		 
		 PaymentResponse resp=new PaymentResponse();
		 resp.setPaymentId(payment.getId());
		 resp.setBookingId(payment.getBooking().getId());
		 resp.setTransactionId(payment.getTransactionId());
		 resp.setAmount(payment.getAmount());
		 resp.setPaymentMethod(payment.getPaymentMethod());
		 resp.setStatus(payment.getStatus());
		 resp.setMessage(payment.getMsg());
		 
		 System.out.println("Payment Response Id"+payment.getId());
		 
		 return resp;
	}

}
