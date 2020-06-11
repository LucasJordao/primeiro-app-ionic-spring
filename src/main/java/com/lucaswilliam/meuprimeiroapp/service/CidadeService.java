package com.lucaswilliam.meuprimeiroapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.domains.Cidade;
import com.lucaswilliam.meuprimeiroapp.repositories.CidadeRepository;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	public CidadeRepository cidadeRepository;
	
	public List<Cidade> findByEstadoId(Integer id){
		return cidadeRepository.findByEstadoId(id);
	}
	
	/**
	 * Metodo responsável por recuperar uma Cidade do banco de dados
	 * 
	 * @param id
	 * @exception ObjectNotFoundException
	 * @return objeto do tipo Cidade
	 */
	public Cidade findById(Integer id) {
		Optional<Cidade> obj = cidadeRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cidade não encontrada. Id:" + id + ", Tipo: " + Cidade.class.getTypeName()));
	}

}
