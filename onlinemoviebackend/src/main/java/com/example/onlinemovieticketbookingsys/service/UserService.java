package com.example.onlinemovieticketbookingsys.service;

import java.util.List;

import com.example.onlinemovieticketbookingsys.beans.User;
import com.example.onlinemovieticketbookingsys.dto.UserResponse;

public interface UserService {
	public User addUser(User u);
	public List<User> getUser();
	public UserResponse getUserById(int id);

}
