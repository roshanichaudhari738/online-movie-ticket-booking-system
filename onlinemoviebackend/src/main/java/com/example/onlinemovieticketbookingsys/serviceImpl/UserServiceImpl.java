package com.example.onlinemovieticketbookingsys.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.onlinemovieticketbookingsys.beans.User;
import com.example.onlinemovieticketbookingsys.dto.LoginRequest;
import com.example.onlinemovieticketbookingsys.dto.LoginResponse;
import com.example.onlinemovieticketbookingsys.dto.UserResponse;
import com.example.onlinemovieticketbookingsys.exceptions.UserNotFoundException;
import com.example.onlinemovieticketbookingsys.repository.UserRepo;
import com.example.onlinemovieticketbookingsys.security.JwtService;
import com.example.onlinemovieticketbookingsys.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JwtService jwt;
	
	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		u.setPassword(
				encoder.encode(u.getPassword())
				);
		return repo.save(u);
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public LoginResponse login(LoginRequest req)
	{
		User u =repo.findByEmail(req.getEmail()).orElse(null);
		
		if(u==null)
		{
			throw new RuntimeException("User not found");
		}
		
		Boolean result=encoder.matches(req.getPassword(), u.getPassword());
		if(result)
		{
			String token= jwt.generateToken(u.getEmail(),u);
			return new LoginResponse(token, u.getRole(),u.getId(),u.getName());
			
		}
		System.out.println("Role "+u.getRole());
		throw new RuntimeException("Invalid user");
	}

	@Override
	public UserResponse getUserById(int id) {
		User user=repo.findById(id).orElseThrow(() -> 
		 new UserNotFoundException("User not found with id"+id));
		
		UserResponse useresp=new UserResponse();
		useresp.setUserId(user.getId());
		useresp.setName(user.getName());
		useresp.setEmail(user.getEmail());
		useresp.setRole(user.getRole());
		
		
		
		return useresp;
		

	}

}
