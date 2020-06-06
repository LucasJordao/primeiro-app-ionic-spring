package com.lucaswilliam.meuprimeiroapp.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {
	
	@GetMapping()
	public ResponseEntity<String> listar(){
		return ResponseEntity.ok().body("Campina Grande - PB");
	}
	
}
