package com.example.onlinemovieticketbookingsys.service;

import java.util.List;

import com.example.onlinemovieticketbookingsys.beans.Screen;

public interface ScreenService {
	public Screen addScreen(int tid,Screen sc);
	public List<Screen> getAllScreen();
	public Screen getScreenById(int id);
}
