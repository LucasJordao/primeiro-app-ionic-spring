package com.lucaswilliam.meuprimeiroapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.domains.Organizacao;
import com.lucaswilliam.meuprimeiroapp.repositories.OrganizacaoRepository;

@Service
public class OrganizacaoService {
	
	//Repositorios
	@Autowired
	private OrganizacaoRepository repo;
	
	/**
	 * Metodo responsável por recuperar uma lista de organizacoes do banco de dados
	 * 
	 * @return Lista de objetos do tipo Organizacoes
	 */
	public List<Organizacao> findAll(){
		List<Organizacao> list = repo.findAll();
		
		return list;
	}
	
}
