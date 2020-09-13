package com.lucaswilliam.meuprimeiroapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.domains.Estado;
import com.lucaswilliam.meuprimeiroapp.repositories.EstadoRepository;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> findAll(){
		List<Estado> list = repo.findAll();
		
		return list;
	}
	
	public Estado findById(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("Estado não encontrado. Id: " + id + ", Tipo: " + Estado.class.getTypeName()));
	}
}
