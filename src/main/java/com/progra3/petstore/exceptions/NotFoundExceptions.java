package com.progra3.petstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundExceptions extends RuntimeException{

	public NotFoundExceptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotFoundExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NotFoundExceptions(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotFoundExceptions(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotFoundExceptions(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
