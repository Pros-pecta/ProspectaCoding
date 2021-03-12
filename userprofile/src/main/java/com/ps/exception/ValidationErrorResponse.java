package com.ps.exception;

import java.io.Serializable;

public class ValidationErrorResponse implements Serializable{

	private String errorMessage;
	private String requestDescription;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getRequestDescription() {
		return requestDescription;
	}
	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}
	public ValidationErrorResponse(String errorMessage, String requestDescription) {
		super();
		this.errorMessage = errorMessage;
		this.requestDescription = requestDescription;
	}
	
	
	
	public ValidationErrorResponse() {
		
	}
	
	
	
}
