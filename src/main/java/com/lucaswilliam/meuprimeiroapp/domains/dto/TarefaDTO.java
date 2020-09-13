package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;
import java.util.Date;

import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoPrioridade;

public class TarefaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	//Attributes
	private Integer id;
	private String titulo;
	private String conteudo;
	private Date dataPrazo;
	private Integer prioridade;
	private Date concluido;
	
	//Constructor and Overloads
	public TarefaDTO() {
		
	}
	
	public TarefaDTO(Tarefa obj) {
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.conteudo = obj.getConteudo();
		this.dataPrazo = obj.getDataPrazo();
		this.prioridade = obj.getPrioridade().getCode();
		this.concluido = obj.getConcluido();
	}

	public TarefaDTO(Integer id, String titulo, String conteudo, Date dataPrazo, TipoPrioridade prioridade, Date concluido) {
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataPrazo = dataPrazo;
		this.prioridade = (prioridade == null) ? null : prioridade.getCode();
		this.concluido = concluido;
	}

	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getDataPrazo() {
			return this.dataPrazo;
		
	}

	public void setDataPrazo(Date dataPrazo) {
		this.dataPrazo = dataPrazo;
	}

	public TipoPrioridade getPrioridade() {
		return TipoPrioridade.toEnum(prioridade);
	}

	public void setPrioridade(TipoPrioridade prioridade) {
		this.prioridade = prioridade.getCode();
	}

	public Date getConcluido() {
			return this.concluido;
	}

	public void setConcluido(Date concluido) {
		this.concluido = concluido;
	}
	
	public boolean getExpirou() {
		Date now = new Date(System.currentTimeMillis());
			return dataPrazo.before(now);
	}
	
}
