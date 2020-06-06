package com.lucaswilliam.meuprimeiroapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;
import com.lucaswilliam.meuprimeiroapp.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository repo;
	
	/**
	 * Metodo responsável por recuperar uma lista de tarefas do banco de dados
	 * @return Lista de objetos do tipo Tarefa
	 */
	public List<Tarefa> findAll(){
		return repo.findAll();
	}
	
}
