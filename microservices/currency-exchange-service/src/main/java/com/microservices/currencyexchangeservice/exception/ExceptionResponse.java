package com.microservices.currencyexchangeservice.exception;

import java.util.Date;

public class ExceptionResponse {

	private String message;
	private String detail;
	private Date timestamp;
	
	public ExceptionResponse() {
		
	}
	
	public ExceptionResponse(String message, String detail, Date timestamp) {
		super();
		this.message = message;
		this.detail = detail;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
