package com.lucaswilliam.meuprimeiroapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
