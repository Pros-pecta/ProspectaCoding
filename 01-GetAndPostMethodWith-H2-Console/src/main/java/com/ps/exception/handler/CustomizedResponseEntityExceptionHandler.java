package com.ps.exception.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ps.model.ErrorType;

/*@ControllerAdvice
@RestController
@Order(1)*/
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


	
 

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    ErrorType exceptionResponse = new ErrorType("not Valide Your operation",
    		ex.getBindingResult().toString());
    	
    return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
  } 
  
  

	
  
  
}
