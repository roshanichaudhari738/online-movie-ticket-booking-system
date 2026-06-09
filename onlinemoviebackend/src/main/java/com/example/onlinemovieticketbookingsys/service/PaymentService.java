package com.example.onlinemovieticketbookingsys.service;

import com.example.onlinemovieticketbookingsys.dto.PaymentRequest;
import com.example.onlinemovieticketbookingsys.dto.PaymentResponse;

public interface PaymentService {

	public PaymentResponse makePayment(
	        PaymentRequest request
	);
}
