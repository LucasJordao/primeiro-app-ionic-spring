package com.lucaswilliam.meuprimeiroapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaswilliam.meuprimeiroapp.domains.Organizacao;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;

public interface OrganizacaoRepository extends JpaRepository<Organizacao, Integer>{

}
