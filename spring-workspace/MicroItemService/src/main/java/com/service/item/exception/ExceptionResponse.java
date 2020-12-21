package com.service.item.exception;

import java.util.Date;

public class ExceptionResponse {

	private String message;
	private String detail;
	private Date timestamp;
	
	
	
	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(String message, String detail, Date timestamp) {
		super();
		this.message = message;
		this.detail = detail;
		this.timestamp = timestamp;
	}
}
