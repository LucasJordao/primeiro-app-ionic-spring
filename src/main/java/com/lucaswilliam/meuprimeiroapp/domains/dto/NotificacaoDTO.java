package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;
import java.util.Date;

public class NotificacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	//Attributes
	private Integer tarefa;
	private UsuarioDTO remetente;
	private UsuarioDTO destinatario;
	private Boolean visualizado;
	private Date instante;
	private String descricao;
	private String conteudo;
	//Constructors and Overloads
	public NotificacaoDTO() {
		
	}

	public NotificacaoDTO(Integer tarefa, UsuarioDTO remetente, UsuarioDTO destinatario, Boolean visualizado,
			Date instante, String conteudo, String descricao) {
		this.tarefa = tarefa;
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.visualizado = visualizado;
		this.instante = instante;
		this.descricao = descricao;
		this.conteudo = conteudo;
	}

	//Getters and Setters
	public Integer getTarefa() {
		return tarefa;
	}

	public void setTarefa(Integer tarefa) {
		this.tarefa = tarefa;
	}

	public UsuarioDTO getRemetente() {
		return remetente;
	}

	public void setRemetente(UsuarioDTO remetente) {
		this.remetente = remetente;
	}

	public UsuarioDTO getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(UsuarioDTO destinatario) {
		this.destinatario = destinatario;
	}

	public Boolean getVisualizado() {
		return visualizado;
	}

	public void setVisualizado(Boolean visualizado) {
		this.visualizado = visualizado;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
}
