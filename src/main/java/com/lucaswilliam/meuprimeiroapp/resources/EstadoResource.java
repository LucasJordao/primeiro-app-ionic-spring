package com.lucaswilliam.meuprimeiroapp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaswilliam.meuprimeiroapp.domains.Estado;
import com.lucaswilliam.meuprimeiroapp.domains.dto.EstadoDTO;
import com.lucaswilliam.meuprimeiroapp.service.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> findAll(){
		List<Estado> list = service.findAll();
		List<EstadoDTO> listDTO = list.stream().map(x -> new EstadoDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Estado> findById(@PathVariable Integer id){
		Estado est = service.findById(id);
		 return ResponseEntity.ok().body(est);
	}

}
