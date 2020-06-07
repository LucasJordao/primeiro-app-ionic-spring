package com.lucaswilliam.meuprimeiroapp.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ORGANIZACAO")
public class Organizacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String fotoPerfil;
	private String descricao;
	
	//Associations
	@JsonIgnore
	@ManyToMany(mappedBy = "organizacoes")
	private List<Usuario> usuarios = new ArrayList<>();
	
	@OneToMany(mappedBy = "organizacao")
	private List<Telefone> telefonesOrganizacao = new ArrayList<>();
	
	@OneToMany(mappedBy = "organizacaoEndereco")
	private List<Endereco> enderecos = new ArrayList<>();
	
	//Constructors and Overloads
	public Organizacao() {
		
	}

	public Organizacao(Integer id, String nome, String fotoPerfil, String descricao) {
		this.id = id;
		this.nome = nome;
		this.fotoPerfil = fotoPerfil;
		this.descricao = descricao;
	}

	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Telefone> getTelefonesOrganizacao() {
		return telefonesOrganizacao;
	}

	public void setTelefonesOrganizacao(List<Telefone> telefonesOrganizacao) {
		this.telefonesOrganizacao = telefonesOrganizacao;
	}
  
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
		Organizacao other = (Organizacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
