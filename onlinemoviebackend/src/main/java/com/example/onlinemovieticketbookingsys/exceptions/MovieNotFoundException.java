package com.example.onlinemovieticketbookingsys.exceptions;

public class MovieNotFoundException extends RuntimeException {
	
	private String msg;
	private int value;
	
	public MovieNotFoundException() {
		super();
		
	}
	
	public MovieNotFoundException(String msg, int value) {
		super(msg+value);
		this.msg = msg;
		this.value = value;
	}
	
	
	
	
}
