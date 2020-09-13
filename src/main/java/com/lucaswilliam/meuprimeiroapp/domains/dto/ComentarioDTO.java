package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private String id;
	private String conteudo;
	private Date instante;
	private UsuarioDTO remetente;
	
	//Constructors and overloads
	public ComentarioDTO() {
		
	}

	public ComentarioDTO(String id, String conteudo, Date instante, UsuarioDTO remetente) {
		this.id = id;
		this.conteudo = conteudo;
		this.instante = instante;
		this.remetente = remetente;
	}

	//Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public UsuarioDTO getRemetente() {
		return remetente;
	}

	public void setRemetente(UsuarioDTO remetente) {
		this.remetente = remetente;
	}
	
}
