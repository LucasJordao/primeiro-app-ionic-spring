package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;

import com.lucaswilliam.meuprimeiroapp.domains.Telefone;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoCargo;

public class UsuarioNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private String nome;
	private String email;
	private String senha;
	private Integer cargo;
	private String fotoPerfil;
	
	private Telefone telefone1;
	private Telefone telefone2;
	private Telefone telefone3;
	
	private String logradouro;
	private String cep;
	private String complemento;
	private String numero;
	private String bairro;
	
	private Integer cidadeId;
	private Integer organizacaoId;
	
	//Constructors and Overloads
	public UsuarioNewDTO() {
		
	}

	public UsuarioNewDTO(Usuario obj) {
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.cargo = obj.getCargo().getCode();
		this.fotoPerfil = obj.getFotoPerfil();
	}
	
	public UsuarioNewDTO(String nome, String email, String senha, Integer cargo, String fotoPerfil, Telefone telefone1,
			Telefone telefone2, Telefone telefone3, String logradouro, String cep, String complemento, String numero,
			String bairro, Integer cidadeId, Integer organizacaoId) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.fotoPerfil = fotoPerfil;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.logradouro = logradouro;
		this.cep = cep;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
		this.cidadeId = cidadeId;
		this.organizacaoId = organizacaoId;
	}
	
	//Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoCargo getCargo() {
		return TipoCargo.toEnum(cargo);
	}

	public void setCargo(TipoCargo cargo) {
		this.cargo = cargo.getCode();
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Telefone getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(Telefone telefone1) {
		this.telefone1 = telefone1;
	}

	public Telefone getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(Telefone telefone2) {
		this.telefone2 = telefone2;
	}

	public Telefone getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(Telefone telefone3) {
		this.telefone3 = telefone3;
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

	public Integer getOrganizacaoId() {
		return organizacaoId;
	}

	public void setOrganizacaoId(Integer organizacaoId) {
		this.organizacaoId = organizacaoId;
	}
	
}
