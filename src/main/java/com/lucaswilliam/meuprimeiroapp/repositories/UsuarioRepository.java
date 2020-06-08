package com.lucaswilliam.meuprimeiroapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lucaswilliam.meuprimeiroapp.domains.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Transactional(readOnly = true)
	Usuario findByEmail(String email);
	
	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Usuario obj INNER JOIN obj.organizacoes org WHERE LOWER(org.nome) = LOWER(:nome)")
	List<Usuario> search(@Param("nome") String nome);
}
