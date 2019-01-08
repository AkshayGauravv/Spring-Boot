package com.springboot.virtualnugetts.exception;

public class ResponseNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResponseNotFoundException() {
		super();
	}

	public ResponseNotFoundException(final String message) {
		super(message);
	}

}
