package com.directors.page.errors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DirectorsNotFoundException extends RuntimeException {
	public DirectorsNotFoundException(String description) {
		super(description);
	}
}
