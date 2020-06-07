package com.lucaswilliam.meuprimeiroapp.service.exceptions;

public class ParseDateException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ParseDateException(String msg) {
		super(msg);
	}

}
