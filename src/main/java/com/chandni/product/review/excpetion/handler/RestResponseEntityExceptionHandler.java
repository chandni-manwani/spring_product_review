package com.chandni.product.review.excpetion.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler
 * @author chandnimanwani
 *
 */
@ControllerAdvice
	public class RestResponseEntityExceptionHandler 
	  extends ResponseEntityExceptionHandler {
	 
	    @ExceptionHandler(value 
	      = { IllegalArgumentException.class, IllegalStateException.class })
	    protected ResponseEntity<Object> handleConflict(
	      RuntimeException ex, WebRequest request) {
	        String bodyOfResponse = "There was an error during processing ! Please try refreshibg the page!";
	        //Log the error at backend
	        System.out.println("Exception occured in API call "+ex.getMessage());
	        return handleExceptionInternal(ex, bodyOfResponse, 
	          new HttpHeaders(), HttpStatus.CONFLICT, request);
	    }
}

