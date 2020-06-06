package com.lucaswilliam.meuprimeiroapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaswilliam.meuprimeiroapp.domains.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
