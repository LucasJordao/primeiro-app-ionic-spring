package com.lucaswilliam.meuprimeiroapp.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoCargo;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private Integer cargo;
	private String fotoPerfil;
	
	//Associations
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "usuario")
	private List<Telefone> telefones = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="ORGANIZACAO_USUARIO",
	joinColumns = @JoinColumn(name="usuario_id"),
	inverseJoinColumns = @JoinColumn(name = "organizacao_id"))
	private List<Organizacao> organizacoes = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioEndereco")
	private List<Endereco> enderecosUsuario = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "usuario")
	private List<Tarefa> tarefas = new ArrayList<>();
	
	
	//Constructors and Overloads
	public Usuario() {
		
	}

	public Usuario(Integer id, String nome, String email, String senha, TipoCargo cargo, String fotoPerfil) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = (cargo == null) ? null : cargo.getCode();
		this.fotoPerfil = fotoPerfil;
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
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Organizacao> getOrganizacoes() {
		return organizacoes;
	}

	public void setOrganizacoes(List<Organizacao> organizacoes) {
		this.organizacoes = organizacoes;
	}

	public List<Endereco> getEnderecosUsuario() {
		return enderecosUsuario;
	}

	public void setEnderecosUsuario(List<Endereco> enderecosUsuario) {
		this.enderecosUsuario = enderecosUsuario;
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
