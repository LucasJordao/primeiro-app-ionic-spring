package com.lucaswilliam.meuprimeiroapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.domains.Organizacao;
import com.lucaswilliam.meuprimeiroapp.repositories.OrganizacaoRepository;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.ObjectNotFoundException;

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
	
	/**
	 * Metodo responsável por recuperar uma Organizacao do banco de dados
	 * 
	 * @param id
	 * @exception ObjectNotFoundException
	 * @return objeto do tipo Organizacao
	 */
	public Organizacao findById(Integer id) {
		Optional<Organizacao> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Organização não encontrada. Id:" + id + ", Tipo: " + Organizacao.class.getTypeName()));
	}
}
