package com.lucaswilliam.meuprimeiroapp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaswilliam.meuprimeiroapp.documents.Notificacao;
import com.lucaswilliam.meuprimeiroapp.domains.dto.NotificacaoDTO;
import com.lucaswilliam.meuprimeiroapp.service.NotificacaoService;

@RestController
@RequestMapping(value = "/notificacoes")
public class NotificacaoResource {

	@Autowired
	private NotificacaoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<NotificacaoDTO>> findAll(@PathVariable Integer id){
		List<Notificacao> list = service.findByDestinatario(id);
		List<NotificacaoDTO> listDTO = list.stream().map(x -> service.fromDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
}
