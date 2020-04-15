package com.books.apirest.exceptions;

public class ApiRestException extends RuntimeException {

	public ApiRestException(String message, Throwable cause) {
		super(message, cause);

	}

	public ApiRestException(String message) {
		super(message);

	}

}
