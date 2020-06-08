package com.lucaswilliam.meuprimeiroapp.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private String field;
	private String  message;
	
	//Constructors and overloads
	public FieldMessage() {
		
	}
	
	public FieldMessage(String field, String message) {
		this.field = field;
		this.message = message;
	}

	//Getters and Setters
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
