package com.lucaswilliam.meuprimeiroapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaswilliam.meuprimeiroapp.domains.Cidade;
import com.lucaswilliam.meuprimeiroapp.service.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<Cidade>> findByEstadoId(@PathVariable Integer id){
		List<Cidade> list = cidadeService.findByEstadoId(id);
		
		return ResponseEntity.ok().body(list);
	}
	
}
