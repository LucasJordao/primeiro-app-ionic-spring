package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoPrioridade;
import com.lucaswilliam.meuprimeiroapp.service.validation.InserirTarefa;

@InserirTarefa
public class TarefaNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// Attributes
	private Integer id;
	@NotEmpty(message="O campo não pode ser vazio")
	@Size(min=10, max=180, message="O tamanho tem que ser entre 10 e 180")
	private String titulo;
	@Size(min=10, max=580, message="O tamanho tem que ser entre 10 e 180")
	private String conteudo;
	@NotEmpty(message="O campo não pode ser vazio")
	private String dataPrazo;
	@Min(value = 0)
	@Max(value = 3)
	@NotNull(message = "Esse campo não pode ser vazio")
	private Integer prioridade;
	private String concluido;
	private String anexoFuncionario;
	private String anexoChefe;
	@NotNull(message = "Esse campo não pode ser vazio")
	private Integer chefe;
	@NotNull(message = "Esse campo não pode ser vazio")
	private Integer funcionario;
	
	// Constructors and overloads
	public TarefaNewDTO() {
		
	}

	public TarefaNewDTO(Integer id, String titulo, String conteudo, String dataPrazo, TipoPrioridade prioridade,
			String concluido, String anexoFuncionario, String anexoChefe, Integer chefe, Integer funcionario) {
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataPrazo = dataPrazo;
		this.prioridade = (prioridade == null) ? null : prioridade.getCode();
		this.concluido = concluido;
		this.anexoFuncionario = anexoFuncionario;
		this.anexoChefe = anexoChefe;
		this.chefe = chefe;
		this.funcionario = funcionario;
	}

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
		return dataPrazo;
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

	public Integer getChefe() {
		return chefe;
	}

	public void setChefe(Integer chefe) {
		this.chefe = chefe;
	}

	public Integer getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}
	
}
