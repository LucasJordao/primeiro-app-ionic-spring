package com.lucaswilliam.meuprimeiroapp.documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Notificacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Attributes
	@Id
	private String id;
	private String conteudo;
	private String descricao;
	private Boolean visualizado;
	private Integer remetente;
	private Integer destinatario;
	private Integer tarefa;
	private Date instante;
	
	//Constructors and Overloads
	public Notificacao() {
		
	}

	public Notificacao(String id, String conteudo, String descricao, Boolean visualizado, Integer remetente,
			Integer destinatario, Integer tarefa, Date instante) {
		super();
		this.id = id;
		this.conteudo = conteudo;
		this.descricao = descricao;
		this.visualizado = visualizado;
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.tarefa = tarefa;
		this.instante = instante;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getVisualizado() {
		return visualizado;
	}

	public void setVisualizado(Boolean visualizado) {
		this.visualizado = visualizado;
	}

	public Integer getRemetente() {
		return remetente;
	}

	public void setRemetente(Integer remetente) {
		this.remetente = remetente;
	}

	public Integer getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Integer destinatario) {
		this.destinatario = destinatario;
	}

	public Integer getTarefa() {
		return tarefa;
	}

	public void setTarefa(Integer tarefa) {
		this.tarefa = tarefa;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	//HashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notificacao other = (Notificacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
