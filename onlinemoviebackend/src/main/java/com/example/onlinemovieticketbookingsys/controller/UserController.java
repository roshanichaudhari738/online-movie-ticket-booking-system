package com.example.onlinemovieticketbookingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinemovieticketbookingsys.beans.User;
import com.example.onlinemovieticketbookingsys.dto.LoginRequest;
import com.example.onlinemovieticketbookingsys.dto.LoginResponse;
import com.example.onlinemovieticketbookingsys.dto.UserResponse;
import com.example.onlinemovieticketbookingsys.serviceImpl.UserServiceImpl;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl service;
	
	@PostMapping("/add")
	public String addUser(@Valid @RequestBody User u)
	{
		service.addUser(u);
		return "Record are save successfully";
	}
	
	@GetMapping("/get")
	public List<User> getUser()
	{
		return service.getUser();
	}
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest req)
	{
		return service.login(req);
	}
	
	@GetMapping("/profile/{id}")
	public UserResponse getUserById(@PathVariable int id)
	{
		return service.getUserById(id);
	}
}
