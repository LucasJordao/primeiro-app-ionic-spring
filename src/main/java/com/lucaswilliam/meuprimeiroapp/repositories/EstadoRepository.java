package com.lucaswilliam.meuprimeiroapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lucaswilliam.meuprimeiroapp.domains.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
	@Transactional(readOnly =  true)
	Estado findByUf(String uf);
	
}
