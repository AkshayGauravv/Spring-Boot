package com.springboot.virtualnugetts.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class VirtualNugettsException extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(ResponseNotFoundException.class)
	public final ResponseEntity<ErrorMessage> somethingWentWrong(ResponseNotFoundException ex) {

		ErrorMessage errorResponse = new ErrorMessage(ex.getMessage(), "Virtual Nugget Exception ");

		return new ResponseEntity<ErrorMessage>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);

	}

}
