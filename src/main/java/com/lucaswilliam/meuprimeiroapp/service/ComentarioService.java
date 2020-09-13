package com.lucaswilliam.meuprimeiroapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.documents.Comentario;
import com.lucaswilliam.meuprimeiroapp.documents.Notificacao;
import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.dto.ComentarioDTO;
import com.lucaswilliam.meuprimeiroapp.domains.dto.UsuarioDTO;
import com.lucaswilliam.meuprimeiroapp.repositories.ComentarioRepository;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.ObjectNotFoundException;

@Service
public class ComentarioService {

	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Autowired
	private ComentarioRepository repo;

	@Autowired
	private NotificacaoService notService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	TarefaService tarefaService;

	/**
	 * Método responsável por retornar todos comentarios por tarefa
	 * 
	 * @param idTarefa
	 */
	public List<Comentario> findByTarefa(Integer idTarefa) {
		tarefaService.findById(idTarefa);
		List<Comentario> lista = repo.findByTarefa(idTarefa);
		return lista;
	}

	/**
	 * Método responsável por inserir um novo comentario
	 * 
	 * @param comentario
	 * @throws ParseException
	 */
	public Comentario insert(Comentario comentario) throws ParseException {
		comentario.setId(null);
		Usuario id = usuarioService.findById(comentario.getIdRemetente());
		Tarefa tarefa = tarefaService.findById(comentario.getIdTarefa());
		Integer destinatario = null;

		String conteudo = "comentou na sua postagem.";
		String descricao = comentario.getConteudo();
		Boolean visualizado = false;
		Integer remetente = id.getId();
		Date instante = sdf2.parse(sdf2.format(new Date()));

		for (Usuario x : tarefa.getUsuario()) {
			if (x.getId().equals(comentario.getIdRemetente())) {
				Notificacao not = new Notificacao(null, conteudo, descricao, visualizado, remetente, destinatario,
						tarefa.getId(), instante);

				Comentario c = repo.save(comentario);
				notService.insert(not);
				
				return c;
			}
		}
		
		throw new ObjectNotFoundException("Você não pode comentar essa tarefa");
	}

	/*
	 * Método responsável por deletar um comentário por id
	 * 
	 * @param id
	 */
	public void delete(String id) {
		Optional<Comentario> c = repo.findById(id);
		c.orElseThrow(() -> new ObjectNotFoundException("Comentario não encontrado. Id: " + id));

		repo.deleteById(id);
	}
	
	/**
	 * Metodo responsável por retornar um lista de comentarios do banco de dados em
	 * paginas
	 * 
	 * @return Page<Comentario>
	 * @param page
	 * @param linePerPage
	 * @param direction
	 * @param orderBy
	 */
	public Page<Comentario> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}

	// Methods Aux
	public ComentarioDTO toDTO(Comentario comentario) {
		UsuarioDTO remetente = new UsuarioDTO(usuarioService.findById(comentario.getIdRemetente()));
		ComentarioDTO comentarioDto = new ComentarioDTO(comentario.getId(), comentario.getConteudo(),
				comentario.getInstante(), remetente);
		return comentarioDto;
	}
}
