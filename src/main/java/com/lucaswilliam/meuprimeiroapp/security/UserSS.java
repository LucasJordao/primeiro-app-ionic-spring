package com.lucaswilliam.meuprimeiroapp.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoCargo;

public class UserSS implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorites;
	
	//Constructors and Overloads
	public UserSS() {
		
	}
	
	public UserSS(Integer id, String email, String senha, Set<TipoCargo> cargos) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorites = cargos.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorites;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}
	
	public Integer getId() {
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
