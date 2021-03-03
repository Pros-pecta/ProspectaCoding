package com.ps.model;


public class ErrorType {
	
	private String message;
	
	private String code;
	
	
	public ErrorType(String message) {
		super();
		this.message = message;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}











	public ErrorType(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}
	
	

}
