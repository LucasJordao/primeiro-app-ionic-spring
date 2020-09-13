package com.lucaswilliam.meuprimeiroapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.lucaswilliam.meuprimeiroapp.documents.Notificacao;

public interface NotificacaoRepository extends MongoRepository<Notificacao, String>{
	
	@Query("{'destinatario' : ?0}")
	List<Notificacao> findByDestinatario(Integer id);
}
