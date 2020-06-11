package com.lucaswilliam.meuprimeiroapp.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucaswilliam.meuprimeiroapp.domains.Endereco;
import com.lucaswilliam.meuprimeiroapp.domains.dto.EnderecoNewDTO;
import com.lucaswilliam.meuprimeiroapp.service.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody EnderecoNewDTO obj){
		Endereco end = service.fromDTO(obj);
		end = service.insert(end);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(end.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
