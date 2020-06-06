package com.lucaswilliam.meuprimeiroapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;
import com.lucaswilliam.meuprimeiroapp.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaResource {
	
	//Service
	@Autowired
	private TarefaService service;
	
	@GetMapping
	public ResponseEntity<List<Tarefa>> findAll(){
		List<Tarefa> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
}
