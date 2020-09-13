package com.lucaswilliam.meuprimeiroapp.domains.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lucaswilliam.meuprimeiroapp.domains.Telefone;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoCargo;
import com.lucaswilliam.meuprimeiroapp.service.validation.InsertUsuario;

@InsertUsuario
public class UsuarioNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	@NotEmpty(message = "Campo não pode ser vazio")
	@Size(min = 7, max = 80, message = "O tamanho tem que ser entre 7 e 80")
	private String nome;
	@NotEmpty(message = "Campo não pode ser vazio")
	@Email(message = "Email inválido")
	@Size(min = 7, max = 80, message = "O tamanho tem que ser entre 7 e 80")
	private String email;
	@Size(min = 8, max = 80, message = "O tamanho tem que ser entre 8 e 80")
	@NotEmpty(message = "Campo não pode ser vazio")
	private String senha;
	@NotNull(message = "Campo não pode ser vazio")
	private Set<Integer> cargos = new HashSet<>();
	private String fotoPerfil;
	
	@NotNull(message = "Campo não pode ser vazio")
	private Telefone telefone1;
	private Telefone telefone2;
	private Telefone telefone3;
	
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
	@NotNull(message = "Campo não pode ser vazio")
	private Integer organizacaoId;
	
	//Constructors and Overloads
	public UsuarioNewDTO() {
		
	}

	public UsuarioNewDTO(Usuario obj) {
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.cargos = obj.getAuthorities().stream().map(x -> x.getCode()).collect(Collectors.toSet());
		this.fotoPerfil = obj.getFotoPerfil();
	}
	
	public UsuarioNewDTO(String nome, String email, String senha, String fotoPerfil, Telefone telefone1,
			Telefone telefone2, Telefone telefone3, String logradouro, String cep, String complemento, String numero,
			String bairro, Integer cidadeId, Integer organizacaoId) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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
	
	public Set<TipoCargo> getCargos(){
		return cargos.stream().map(x -> TipoCargo.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addCargo(TipoCargo cargo) {
		cargos.add(cargo.getCode());
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
