package com.lucaswilliam.meuprimeiroapp.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{
	
	@Transactional
	@Query("SELECT DISTINCT obj FROM Tarefa obj INNER JOIN obj.usuario user WHERE user.id = :usuarioId")
	List<Tarefa> findByUsuario(@Param("usuarioId") Integer usuarioId);
}
