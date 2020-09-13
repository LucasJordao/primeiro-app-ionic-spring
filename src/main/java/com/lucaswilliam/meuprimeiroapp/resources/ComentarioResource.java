package com.lucaswilliam.meuprimeiroapp.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaswilliam.meuprimeiroapp.service.ComentarioService;

@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioResource {
	
	@Autowired
	private ComentarioService service;
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
