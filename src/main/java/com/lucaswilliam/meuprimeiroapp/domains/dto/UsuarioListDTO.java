package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;

import com.lucaswilliam.meuprimeiroapp.domains.Usuario;

public class UsuarioListDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private Integer id;
	private String nome;
	private String email;
	private String fotoPerfil;
	private boolean primeiroAcesso;
	
	//constructors and overloads
	public UsuarioListDTO() {
		
	}
	
	public UsuarioListDTO(Usuario obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.fotoPerfil = obj.getFotoPerfil();
		this.primeiroAcesso = obj.getPrimeiroAcesso();
	}

	public UsuarioListDTO(Integer id, String nome, String email, String fotoPerfil, boolean primeiroAcesso) {
		this.nome = nome;
		this.email = email;
		this.fotoPerfil = fotoPerfil;
		this.primeiroAcesso = primeiroAcesso;
	}

	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public boolean isPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(boolean primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}

}
