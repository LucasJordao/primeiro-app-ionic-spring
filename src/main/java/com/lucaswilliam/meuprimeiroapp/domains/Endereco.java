package com.lucaswilliam.meuprimeiroapp.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String logradouro;
	private String cep;
	private String complemento;
	private String numero;
	private String bairro;
	
	//Associations
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuarioEndereco;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "organizacao_id")
	private Organizacao organizacaoEndereco;
	
	//Constructor and overloads
	public Endereco() {
		
	}

	public Endereco(Integer id, String logradouro, String cep, String complemento, String numero, String bairro, Usuario usuario, Cidade cidade, Organizacao organizacao) {
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
		this.usuarioEndereco = usuario;
		this.cidade = cidade;
		this.organizacaoEndereco = organizacao;
	}

	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Usuario getUsuarioEndereco() {
		return usuarioEndereco;
	}

	public void setUsuarioEndereco(Usuario usuarioEndereco) {
		this.usuarioEndereco = usuarioEndereco;
	}

	public Organizacao getOrganizacaoEndereco() {
		return organizacaoEndereco;
	}

	public void setOrganizacaoEndereco(Organizacao organizacaoEndereco) {
		this.organizacaoEndereco = organizacaoEndereco;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
