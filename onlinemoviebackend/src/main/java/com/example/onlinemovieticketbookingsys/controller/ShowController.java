package com.example.onlinemovieticketbookingsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinemovieticketbookingsys.beans.Show;
import com.example.onlinemovieticketbookingsys.dto.ShowResponse;
import com.example.onlinemovieticketbookingsys.serviceImpl.ShowServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/user/show")
public class ShowController {
	@Autowired
	private ShowServiceImpl show;
	
	@GetMapping("/getall")
	public List<Show> getAllShow()
	{
		return show.getAllShow();
	}
	
	@GetMapping("/movie/{movieId}")
	public List<ShowResponse> getShowById(@PathVariable int movieId)
	{
		return show.getShowById(movieId);
	}
	
//	@GetMapping("/shows")
//	public List<Show> getShows()
//	{
//	    return show.getAvailableShows();
//	}
}
