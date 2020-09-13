package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private String email;
	private String senha;
	
	//Constructors and Overloads
	public CredenciaisDTO() {
		
	}

	public CredenciaisDTO(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	//Getters and Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
