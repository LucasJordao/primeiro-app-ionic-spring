package com.lucaswilliam.meuprimeiroapp.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends StandardError {

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private List<FieldMessage> error = new ArrayList<>();

	public ValidationException() {
		
	}

	public ValidationException(Integer code, String message, String uri, Long instant) {
		super(code, message, uri, instant);
	}

	//Getters and Setters
	public List<FieldMessage> getError() {
		return error;
	}

	public void addError(FieldMessage error) {
		this.error.add(error);
	}

	
}
