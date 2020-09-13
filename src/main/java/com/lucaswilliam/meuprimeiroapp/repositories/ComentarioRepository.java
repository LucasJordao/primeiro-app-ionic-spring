package com.lucaswilliam.meuprimeiroapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.lucaswilliam.meuprimeiroapp.documents.Comentario;

public interface ComentarioRepository extends MongoRepository<Comentario, String>{
	@Query(value="{'idTarefa' : ?0}")
	List<Comentario> findByTarefa(Integer id);
}
