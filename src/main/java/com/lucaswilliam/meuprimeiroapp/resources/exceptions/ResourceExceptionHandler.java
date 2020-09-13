package com.lucaswilliam.meuprimeiroapp.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucaswilliam.meuprimeiroapp.service.exceptions.DataIntegrityException;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.EmailException;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationException> MethodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest http){
		HttpStatus code = HttpStatus.BAD_REQUEST;
		ValidationException err = new ValidationException(code.value(), "Erro de validação", http.getRequestURI(), System.currentTimeMillis());
		
		for(FieldError x: e.getBindingResult().getFieldErrors()) {
			err.addError(new FieldMessage(x.getField(), x.getDefaultMessage()));
		}
		
		return ResponseEntity.status(code).body(err);
	}
	
	@ExceptionHandler(EmailException.class)
	public ResponseEntity<StandardError> EmailException(EmailException e, HttpServletRequest http){
		HttpStatus code = HttpStatus.REQUEST_TIMEOUT;
		StandardError err = new StandardError(code.value(), e.getMessage(), http.getRequestURI(), System.currentTimeMillis());
		
		return ResponseEntity.status(code).body(err);
	}
	
}
