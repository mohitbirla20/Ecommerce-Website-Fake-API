package com.project.Exceptions;

public class InvalidCredentialsException extends Exception{

	public InvalidCredentialsException() {
		
	}
	
	public InvalidCredentialsException(String message) {
		super(message);
	}
	
}
