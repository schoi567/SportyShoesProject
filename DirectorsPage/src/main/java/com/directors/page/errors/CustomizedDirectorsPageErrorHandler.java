package com.directors.page.errors;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.directors.page.domain.Directors;


 
@RestControllerAdvice
public class CustomizedDirectorsPageErrorHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Directors> handleAllException(Exception ex, WebRequest request) throws Exception {
		DirectorsErrorResponse errorResponse = 
				new DirectorsErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DirectorsNotFoundException.class)
	public final ResponseEntity<Directors> handleDirectorsNotFoundExceptionException(Exception ex, WebRequest request) throws Exception {
		DirectorsErrorResponse errorResponse = 
				new DirectorsErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		DirectorsErrorResponse errorResponse = 
				new DirectorsErrorResponse(new Date(), "Validation Failed", ex.getBindingResult().toString());
		return new ResponseEntity(errorResponse,HttpStatus.BAD_REQUEST);
	}


}
