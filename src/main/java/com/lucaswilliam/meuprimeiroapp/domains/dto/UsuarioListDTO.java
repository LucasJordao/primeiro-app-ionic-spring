package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;

import com.lucaswilliam.meuprimeiroapp.domains.Usuario;

public class UsuarioListDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private String nome;
	private String email;
	private Integer cargo;
	private String fotoPerfil;
	private boolean primeiroAcesso;
	
	//constructors and overloads
	public UsuarioListDTO() {
		
	}
	
	public UsuarioListDTO(Usuario obj) {
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.cargo = (obj.getCargo() == null) ? null : obj.getCargo().getCode();
		this.fotoPerfil = obj.getFotoPerfil();
		this.primeiroAcesso = obj.getPrimeiroAcesso();
	}

	public UsuarioListDTO(String nome, String email, Integer cargo, String fotoPerfil, boolean primeiroAcesso) {
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
		this.fotoPerfil = fotoPerfil;
		this.primeiroAcesso = primeiroAcesso;
	}

	//Getters and Setters
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

	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Integer cargo) {
		this.cargo = cargo;
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
