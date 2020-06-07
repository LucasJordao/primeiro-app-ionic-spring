package com.lucaswilliam.meuprimeiroapp.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private Integer code;
	private String message;
	private String uri;
	private Long instant;
	
	//Constructor and Overloads
	public StandardError() {
		
	}

	public StandardError(Integer code, String message, String uri, Long instant) {
		this.code = code;
		this.message = message;
		this.uri = uri;
		this.instant = instant;
	}

	//Getters and Setters
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Long getInstant() {
		return instant;
	}

	public void setInstant(Long instant) {
		this.instant = instant;
	}
}
