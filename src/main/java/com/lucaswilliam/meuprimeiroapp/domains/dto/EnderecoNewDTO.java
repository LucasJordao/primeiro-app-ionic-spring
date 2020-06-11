package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.lucaswilliam.meuprimeiroapp.domains.Endereco;

public class EnderecoNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private Integer id;
	@NotEmpty(message = "Campo não pode ser vazio")
	private String logradouro;
	@NotEmpty(message = "Campo não pode ser vazio")
	private String cep;
	private String complemento;
	@NotEmpty(message = "Campo não pode ser vazio")
	private String numero;
	@NotEmpty(message = "Campo não pode ser vazio")
	private String bairro;
	@NotNull(message = "Campo não pode ser vazio")
	private Integer cidadeId;
	private Integer usuarioId;
	private Integer OrganizacaoId;
	
	
	//Constructors and Overloads
	public EnderecoNewDTO() {
		
	}

	public EnderecoNewDTO(Endereco obj) {
		this.id = obj.getId();
		this.bairro = obj.getBairro();
		this.logradouro = obj.getLogradouro();
		this.cep = obj.getCep();
		this.complemento = obj.getComplemento();
		this.numero = obj.getNumero();
	}

	public EnderecoNewDTO(Integer id, String logradouro, String cep, String complemento, String numero, String bairro,
			Integer cidadeId, Integer usuarioId, Integer organizacaoId) {
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
		this.cidadeId = cidadeId;
		this.usuarioId = usuarioId;
		OrganizacaoId = organizacaoId;
	}
	
	//Getters and setters
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

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getOrganizacaoId() {
		return OrganizacaoId;
	}

	public void setOrganizacaoId(Integer organizacaoId) {
		OrganizacaoId = organizacaoId;
	}
	
}
