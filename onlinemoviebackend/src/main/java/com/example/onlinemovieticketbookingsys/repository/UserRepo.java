package com.example.onlinemovieticketbookingsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinemovieticketbookingsys.beans.User;
import com.example.onlinemovieticketbookingsys.dto.UserResponse;

import java.util.List;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Integer> {
		Optional<User> findByEmail(String email);
//		List<User> findById(int id);
		UserResponse save(UserResponse useresp);

}
