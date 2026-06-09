package com.example.onlinemovieticketbookingsys.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = MovieNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleMovieNotFoundExcep(MovieNotFoundException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
	}
	
	@ExceptionHandler(value = TheatreNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleTheaterNotFound(TheatreNotFoundException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
	
	@ExceptionHandler(value = ScreenNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleScreenNotFound(ScreenNotFoundException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
	@ExceptionHandler(value = ShowNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleShowNotFound(ShowNotFoundException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
	@ExceptionHandler(value = SeatAlreadyBookedException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleShowNotFound(SeatAlreadyBookedException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleUserNotFound(UserNotFoundException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
}
