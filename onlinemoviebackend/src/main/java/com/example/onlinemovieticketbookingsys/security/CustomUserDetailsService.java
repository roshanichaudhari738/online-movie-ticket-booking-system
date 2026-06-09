package com.example.onlinemovieticketbookingsys.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.onlinemovieticketbookingsys.beans.User;
import com.example.onlinemovieticketbookingsys.repository.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User u=repo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("USer not found"));
		
		return org.springframework.security.core.userdetails.User
				.builder()
				.username(u.getEmail())
				.password(u.getPassword())
				.authorities(u.getRole())
				.build();
		
	}
	

}
