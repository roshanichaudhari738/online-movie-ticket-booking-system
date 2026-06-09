package com.example.onlinemovieticketbookingsys.exceptions;

public class TheatreNotFoundException extends RuntimeException {
	private String msg;

	public TheatreNotFoundException(String message) {
		super(message); //pass the msg of the parent runtime exception
	}
	
	
}
