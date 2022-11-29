package com.project.Exceptions;

public class EmptyCartException extends Exception{

	public EmptyCartException() {
		
	}
	
	public EmptyCartException(String m) {
		super(m);
	}
	
}
