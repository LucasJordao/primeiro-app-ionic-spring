package com.lucaswilliam.meuprimeiroapp.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucaswilliam.meuprimeiroapp.service.exceptions.DataIntegrityException;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.ObjectNotFoundException;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.ParseDateException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> NotFoundException(ObjectNotFoundException e, HttpServletRequest http){
		HttpStatus code = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(code.value(), e.getMessage(), http.getRequestURI(), System.currentTimeMillis());
		
		return ResponseEntity.status(code).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> DataIntegrityException(DataIntegrityException e, HttpServletRequest http){
		HttpStatus code = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(code.value(), e.getMessage(), http.getRequestURI(), System.currentTimeMillis());
		
		return ResponseEntity.status(code).body(err);
	}
	
	@ExceptionHandler(ParseDateException.class)
	public ResponseEntity<StandardError> ParseDateException(ParseDateException e, HttpServletRequest http){
		HttpStatus code = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(code.value(), e.getMessage(), http.getRequestURI(), System.currentTimeMillis());
		
		return ResponseEntity.status(code).body(err);
	}
}
