package com.vecio.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//construtor sobrecarregado
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
