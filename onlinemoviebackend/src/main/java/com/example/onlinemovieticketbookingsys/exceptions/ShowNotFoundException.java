package com.example.onlinemovieticketbookingsys.exceptions;

public class ShowNotFoundException extends RuntimeException {
		private String msg;
		
		public ShowNotFoundException(String msg) {
			super(msg);
		}
}
