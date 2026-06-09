package com.example.onlinemovieticketbookingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinemovieticketbookingsys.beans.Screen;
import com.example.onlinemovieticketbookingsys.serviceImpl.ScreenServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/screen")
public class ScreenController {

	@Autowired
	private ScreenServiceImpl sc;
	
	@GetMapping("/all")
	public List<Screen> getAllScreen()
	{
		return sc.getAllScreen();
	}
	
	@GetMapping("/get/{id}")
	public Screen getScreenById(@PathVariable int id)
	{
		return sc.getScreenById(id);
	} 
}
