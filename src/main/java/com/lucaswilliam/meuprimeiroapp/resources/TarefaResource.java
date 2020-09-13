package com.lucaswilliam.meuprimeiroapp.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.lucaswilliam.meuprimeiroapp.documents.Comentario;
import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;
import com.lucaswilliam.meuprimeiroapp.domains.dto.ComentarioDTO;
import com.lucaswilliam.meuprimeiroapp.domains.dto.TarefaDTO;
import com.lucaswilliam.meuprimeiroapp.domains.dto.TarefaNewDTO;
import com.lucaswilliam.meuprimeiroapp.domains.dto.TarefaUpdateDTO;
import com.lucaswilliam.meuprimeiroapp.service.ComentarioService;
import com.lucaswilliam.meuprimeiroapp.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaResource {
	
	//Service
	@Autowired
	private TarefaService service;
	
	@Autowired
	private ComentarioService serviceComentario;
	
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
	
	@PreAuthorize("hasAnyRole('CHEFE')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('CHEFE')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody TarefaUpdateDTO objDTO){
		objDTO.setId(id);
		Tarefa obj = service.fromDTO(objDTO);
		service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('CHEFE')")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody TarefaNewDTO objDto) throws ParseException{
		Tarefa obj = service.fromDTO(objDto);
		obj = service.insert(obj, objDto.getFuncionario(), objDto.getChefe());
		
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
	
	@PostMapping(value = "/{id}/comentarios")
	public ResponseEntity<Void> insert(@Valid @RequestBody Comentario comentario, @PathVariable Integer id) throws ParseException{
		comentario.setIdTarefa(id);
		Comentario c = serviceComentario.insert(comentario);
		
		URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/comentarios").buildAndExpand(c.getId()).toUri();
		
		return ResponseEntity.created(local).build();
	}
	
	@GetMapping(value = "/{id}/comentarios")
	public ResponseEntity<List<ComentarioDTO>> findAll(@PathVariable Integer id){
		List<Comentario> lista = serviceComentario.findByTarefa(id);
		List<ComentarioDTO> listaDto = lista.stream().map(x -> serviceComentario.toDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaDto);
	}
	
	@GetMapping(value = "/{id}/comentarios/page")
	public ResponseEntity<Page<Comentario>> findComentarioPerPage(
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name="lineperpage", defaultValue = "24") Integer linePerPage,
			@RequestParam(name = "direction", defaultValue = "ASC") String direction,
			@RequestParam(name = "orderBy", defaultValue = "nome") String orderBy
			){
		Page<Comentario> lista = serviceComentario.findPage(page, linePerPage, direction, orderBy);
		return ResponseEntity.ok().body(lista);
	}
}
