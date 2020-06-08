package com.lucaswilliam.meuprimeiroapp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;
import com.lucaswilliam.meuprimeiroapp.domains.dto.TarefaDTO;
import com.lucaswilliam.meuprimeiroapp.domains.dto.TarefaNewDTO;
import com.lucaswilliam.meuprimeiroapp.domains.dto.TarefaUpdateDTO;
import com.lucaswilliam.meuprimeiroapp.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaResource {
	
	//Service
	@Autowired
	private TarefaService service;
	
	@GetMapping
	public ResponseEntity<List<TarefaDTO>> findAll(){
		List<Tarefa> list = service.findAll();
		List<TarefaDTO> listDTO = list.stream().map(obj -> new TarefaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable Integer id){
		Tarefa tarefa = service.findById(id);
		
		return ResponseEntity.ok().body(tarefa);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody TarefaUpdateDTO objDTO){
		objDTO.setId(id);
		Tarefa obj = service.fromDTO(objDTO);
		service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Void> update(@Valid @RequestBody TarefaNewDTO objDto){
		Tarefa obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Tarefa>> findPage(
			@RequestParam Integer page,
			@RequestParam Integer linePerPage, 
			@RequestParam String direction,
			@RequestParam String orderBy){
		
		Page<Tarefa> list = service.findPage(page, linePerPage, direction, orderBy);
		
		return ResponseEntity.ok().body(list);
		
	}
}
