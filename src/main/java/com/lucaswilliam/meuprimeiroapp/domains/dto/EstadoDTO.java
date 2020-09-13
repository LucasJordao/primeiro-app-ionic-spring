package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;

import com.lucaswilliam.meuprimeiroapp.domains.Estado;

public class EstadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Atrributes
	private Integer id;
	private String nome;
	private String uf;
	
	//Constructor and Overloads
	public EstadoDTO() {
		
	}

	public EstadoDTO(Estado est) {
		this.nome = est.getNome();
		this.id = est.getId();
		this.uf = est.getUf();
	}
	
	public EstadoDTO(Integer id, String nome, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
