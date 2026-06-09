package com.example.onlinemovieticketbookingsys.dto;

import java.util.List;

public class BookingRequest {
	private int userId;
	private int showId;
	private List<Integer> seatId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public List<Integer> getSeatId() {
		return seatId;
	}
	public void setSeatId(List<Integer> seatId) {
		this.seatId = seatId;
	}
	
	
}
