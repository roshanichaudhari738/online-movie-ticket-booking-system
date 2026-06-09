package com.example.onlinemovieticketbookingsys.service;

import java.util.List;

import com.example.onlinemovieticketbookingsys.beans.Show;
import com.example.onlinemovieticketbookingsys.dto.ShowResponse;

public interface ShowService {

	public Show addShow(int mid,int scid,Show show);
	public List<Show> getAllShow();
	public List<ShowResponse> getShowById(int id);
}
