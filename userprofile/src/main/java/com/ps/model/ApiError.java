package com.ps.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class ApiError {
	
	private HttpStatus status;
	
    public ApiError(HttpStatus status, String message) {
		super();
		this.status = status;
	}

	private String message;
    private List<String> errors;
    
    
    
    public ApiError(final HttpStatus status, final String message, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
    
    
    public ApiError(final HttpStatus status, final String message, final HttpMessageNotReadableException ex) {
        super();
        this.status = status;
        this.message = message;
      
    }
    		
    		
    		
    		

    public ApiError(final HttpStatus status, final String message, final String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

	

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
    
    
    
    
    
    
    
    
    
	
	

}
