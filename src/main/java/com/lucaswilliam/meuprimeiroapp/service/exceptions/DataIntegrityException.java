package com.lucaswilliam.meuprimeiroapp.service.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String s) {
		super(s);
	}
}
