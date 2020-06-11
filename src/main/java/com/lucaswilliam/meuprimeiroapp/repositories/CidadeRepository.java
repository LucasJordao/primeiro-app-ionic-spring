package com.lucaswilliam.meuprimeiroapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lucaswilliam.meuprimeiroapp.domains.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	
	@Transactional(readOnly = true)
	List<Cidade> findByEstadoId(Integer id);
	
}
