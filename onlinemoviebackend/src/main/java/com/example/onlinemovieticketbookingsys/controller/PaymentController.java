package com.example.onlinemovieticketbookingsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinemovieticketbookingsys.dto.PaymentRequest;
import com.example.onlinemovieticketbookingsys.dto.PaymentResponse;
import com.example.onlinemovieticketbookingsys.serviceImpl.PaymentServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class PaymentController {
	
	@Autowired
	private PaymentServiceImpl pay;
	
	@PostMapping("/pay")
	public PaymentResponse paymentmethod(@RequestBody PaymentRequest req)
	{
		System.out.println("Payment API called!!!");
		return pay.makePayment(req);
	}
}
