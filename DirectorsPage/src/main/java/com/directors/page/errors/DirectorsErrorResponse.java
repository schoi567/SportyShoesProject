package com.directors.page.errors;

import java.util.Date;

public class DirectorsErrorResponse {
	
	private Date time;
	private String message;
	private String details;
	
	public DirectorsErrorResponse(Date time, String message, String details) {
		super();
		this.time = time;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return time;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
