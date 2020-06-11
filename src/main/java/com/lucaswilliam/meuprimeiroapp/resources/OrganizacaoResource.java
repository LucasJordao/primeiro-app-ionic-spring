package com.lucaswilliam.meuprimeiroapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaswilliam.meuprimeiroapp.domains.Organizacao;
import com.lucaswilliam.meuprimeiroapp.service.OrganizacaoService;

@RestController
@RequestMapping(value = "/organizacoes")
public class OrganizacaoResource {

	//Service
	@Autowired
	private OrganizacaoService service;
	
	@GetMapping
	public ResponseEntity<List<Organizacao>> findAll(){
		
		List<Organizacao> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
}
