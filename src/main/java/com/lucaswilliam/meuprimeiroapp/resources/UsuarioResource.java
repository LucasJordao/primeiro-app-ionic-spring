package com.lucaswilliam.meuprimeiroapp.resources;

import java.net.URI;
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

import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.dto.UsuarioDTO;
import com.lucaswilliam.meuprimeiroapp.domains.dto.UsuarioListDTO;
import com.lucaswilliam.meuprimeiroapp.domains.dto.UsuarioNewDTO;
import com.lucaswilliam.meuprimeiroapp.service.TarefaService;
import com.lucaswilliam.meuprimeiroapp.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private TarefaService tarefaService;
	
	//EndPoints (Rotas)
	@GetMapping
	public ResponseEntity<List<UsuarioListDTO>> findAll(){
		List<Usuario> lista = service.findAll();
		List<UsuarioListDTO> list = lista.stream().map(x -> new UsuarioListDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id){
		Usuario obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id,@Valid @RequestBody UsuarioDTO objDTO){
		objDTO.setId(id);
		Usuario obj = service.fromDTO(objDTO);
		service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Usuario>> findPage(
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "linePerPage", defaultValue = "24") Integer linePerPage,
			@RequestParam(name = "direction", defaultValue = "ASC") String direction,
			@RequestParam(name = "orderBy", defaultValue = "nome") String orderBy){
		
		Page<Usuario> list = service.findPage(page, linePerPage, direction, orderBy);
		
		return ResponseEntity.ok().body(list);
	}
	
	@PreAuthorize("hasAnyRole('CHEFE')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('CHEFE')")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioNewDTO obj){
		Usuario user = service.insert(service.fromNewDTO(obj));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/organizacoes")
	public ResponseEntity<List<Usuario>> search(@RequestParam(name = "org", defaultValue = "") String org){
		List<Usuario> list = service.search(org);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{usuarioId}/tarefas")
	public ResponseEntity<List<Tarefa>> findByTarefa(@PathVariable Integer usuarioId){
		List<Tarefa> tarefas = tarefaService.findByUsuario(usuarioId);
		
		return ResponseEntity.ok().body(tarefas);
	}
}
