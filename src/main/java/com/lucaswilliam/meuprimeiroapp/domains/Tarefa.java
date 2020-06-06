package com.lucaswilliam.meuprimeiroapp.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoPrioridade;

@Entity
@Table(name = "TAREFA")
public class Tarefa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String conteudo;
	private String anexoChefe;
	private String anexoFuncionario;
	private Date dataCriacao;
	private Date dataPrazo;
	private Integer prioridade;
	private Date concluido;
	
	//Associations
	@ManyToMany
	@JoinTable(name = "TAREFA_USUARIO", joinColumns = @JoinColumn(name = "tarefa_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	private List<Usuario> usuario = new ArrayList<>();

	//Constructors and Overloads
	public Tarefa() {
		
	}

	public Tarefa(Integer id, String titulo, String conteudo, String anexoChefe, String anexoFuncionario,
			Date dataCriacao, Date dataPrazo, TipoPrioridade prioridade, Date concluido) {
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.anexoChefe = anexoChefe;
		this.anexoFuncionario = anexoFuncionario;
		this.dataCriacao = dataCriacao;
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

	public String getAnexoChefe() {
		return anexoChefe;
	}

	public void setAnexoChefe(String anexoChefe) {
		this.anexoChefe = anexoChefe;
	}

	public String getAnexoFuncionario() {
		return anexoFuncionario;
	}

	public void setAnexoFuncionario(String anexoFuncionario) {
		this.anexoFuncionario = anexoFuncionario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataPrazo() {
		return dataPrazo;
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
		return concluido;
	}

	public void setConcluido(Date concluido) {
		this.concluido = concluido;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	//Hashcode and Equals
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
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
