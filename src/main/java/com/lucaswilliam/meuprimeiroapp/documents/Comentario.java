package com.lucaswilliam.meuprimeiroapp.documents;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comentario implements Serializable{

	private static final long serialVersionUID = 1L;
	//Attributes
	@Id
	private String id;
	private String conteudo;
	@NotNull(message = "O ID do REMETENTE não pode ser vazio")
	private Integer idRemetente;
	@NotNull(message = "O ID da TAREFA não pode ser vazio")
	private Integer idTarefa;
	private Date instante;
	
	//Constructors and Overloads
	public Comentario() {
		
	}

	public Comentario(String id, String conteudo, Integer idRemetente, Integer idTarefa, Date instante) {
		this.id = id;
		this.conteudo = conteudo;
		this.idRemetente = idRemetente;
		this.idTarefa = idTarefa;
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

	public Integer getIdRemetente() {
		return idRemetente;
	}

	public void setIdRemetente(Integer idRemetente) {
		this.idRemetente = idRemetente;
	}

	public Integer getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
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
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
