package com.lucaswilliam.meuprimeiroapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	//Repositories
	@Autowired
	private UsuarioRepository repo;
	
	/**
	 * Metodo responsável por recuperar uma lista de usuarios do banco de dados
	 * @return Lista de objetos do tipo Usuario
	 */
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
}
