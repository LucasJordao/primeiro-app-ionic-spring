package com.lucaswilliam.meuprimeiroapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaswilliam.meuprimeiroapp.domains.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer>{

}
