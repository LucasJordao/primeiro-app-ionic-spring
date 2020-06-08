package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Size;

import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoPrioridade;

public class TarefaUpdateDTO implements Serializable{

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static final long serialVersionUID = 1L;

	//Attributes
	private Integer id;
	@Size(min=10, max=180, message="O tamanho tem que ser entre 10 e 180")
	private String titulo;
	@Size(min=10, max=580, message="O tamanho tem que ser entre 10 e 180")
	private String conteudo;
	private String dataPrazo;
	private Integer prioridade;
	private String concluido;
	private String anexoFuncionario;
	private String anexoChefe;
	
	//Constructor and Overloads
	public TarefaUpdateDTO() {
		
	}
	
	public TarefaUpdateDTO(Tarefa obj) {
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.conteudo = obj.getConteudo();
		this.dataPrazo = sdf.format(obj.getDataPrazo());
		this.prioridade = obj.getPrioridade().getCode();
		this.concluido = sdf2.format(obj.getConcluido());
		this.anexoFuncionario = obj.getAnexoFuncionario();
		this.anexoChefe = obj.getAnexoChefe();
	}

	public TarefaUpdateDTO(Integer id, String titulo, String conteudo, String dataPrazo, TipoPrioridade prioridade,
			String concluido, String anexoFuncionario, String anexoChefe) {
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataPrazo = dataPrazo;
		this.prioridade = (prioridade == null) ? null : prioridade.getCode();
		this.concluido = concluido;
		this.anexoFuncionario = anexoFuncionario;
		this.anexoChefe = anexoChefe;
	}

	//getters and Setters
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

	public String getDataPrazo() {
		return this.dataPrazo;
	}

	public void setDataPrazo(String dataPrazo) {
		this.dataPrazo = dataPrazo;
	}

	public TipoPrioridade getPrioridade() {
		return TipoPrioridade.toEnum(prioridade);
	}

	public void setPrioridade(TipoPrioridade prioridade) {
		this.prioridade = prioridade.getCode();
	}

	public String getConcluido() {
		return concluido;
	}

	public void setConcluido(String concluido) {
		this.concluido = concluido;
	}

	public String getAnexoFuncionario() {
		return anexoFuncionario;
	}

	public void setAnexoFuncionario(String anexoFuncionario) {
		this.anexoFuncionario = anexoFuncionario;
	}

	public String getAnexoChefe() {
		return anexoChefe;
	}

	public void setAnexoChefe(String anexoChefe) {
		this.anexoChefe = anexoChefe;
	}
	
}
