package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.service.validation.UpdateUsuario;

@UpdateUsuario
public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private Integer id;
	@Size(min = 7, max = 80, message = "O tamanho tem que ser entre 7 e 80")
	private String nome;
	@NotEmpty(message = "Campo não pode ser vazio")
	@Email(message = "Email inválido")
	private String email;
	@Size(min = 8, max = 80, message = "O tamanho tem que ser entre 8 e 80")
	private String senha;
	private Integer cargo;
	private String fotoPerfil;
	
	//Constructor and overloads
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Usuario obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.cargo = obj.getCargo().getCode();
		this.fotoPerfil = obj.getFotoPerfil();
	}
	
	public UsuarioDTO(Integer id, String nome, String email, String senha, Integer cargo, String fotoPerfil) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.fotoPerfil = fotoPerfil;
	}

	//Getters and Setters
	public String getNome() {
		return nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
}
