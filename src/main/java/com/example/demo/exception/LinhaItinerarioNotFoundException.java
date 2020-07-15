package com.example.demo.exception;

public class LinhaItinerarioNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public LinhaItinerarioNotFoundException(Long id) {
		super("Não foi possível encontrar linha com id: {" + id + "}");
	}
	
}
