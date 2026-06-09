package com.example.onlinemovieticketbookingsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinemovieticketbookingsys.beans.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
