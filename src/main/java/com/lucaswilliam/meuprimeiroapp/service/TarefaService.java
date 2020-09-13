package com.lucaswilliam.meuprimeiroapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucaswilliam.meuprimeiroapp.documents.Notificacao;
import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.dto.TarefaNewDTO;
import com.lucaswilliam.meuprimeiroapp.domains.dto.TarefaUpdateDTO;
import com.lucaswilliam.meuprimeiroapp.repositories.TarefaRepository;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.ObjectNotFoundException;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.ParseDateException;

@Service
public class TarefaService {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	@Autowired
	private TarefaRepository repo;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private NotificacaoService notificacaoService;
	
	/**
	 * Metodo responsável por recuperar uma lista de tarefas do banco de dados
	 * 
	 * @return Lista de objetos do tipo Tarefa
	 */
	public List<Tarefa> findAll() {
		return repo.findAll();
	}

	/**
	 * Metodo responsável por recuperar uma Tarefa do banco de dados
	 * 
	 * @param id
	 * @exception ObjectNotFoundException
	 * @return objeto do tipo Tarefa
	 */
	public Tarefa findById(Integer id) {
		if (id == null) {
			return null;
		}
		Optional<Tarefa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. Id: " + id + ", Tipo: " + Tarefa.class.getTypeName()));
	}

	/**
	 * Metodo responsável por deletar uma tarefa do banco de dados
	 * 
	 * @param id
	 * @exception ObjectNotFoundException
	 * @return void
	 */
	public void delete(Integer id) {
		Tarefa obj = this.findById(id);
		repo.delete(obj);
	}
	
	/**
	 * Metodo responsável por atualizar uma tarefa do banco de dados
	 * 
	 * @param obj
	 * @exception ObjectNotFoundException
	 * @return void
	 */
	public void update(Tarefa obj) {
		Tarefa newObj = this.findById(obj.getId());
		updateData(obj, newObj);
		repo.save(newObj);
	}
	
	/**
	 * Metodo responsável por inserir uma tarefa no banco de dados
	 * 
	 * @param obj
	 * 
	 * @return Objeto do tipo Tarefa
	 * @throws ParseException 
	 */
	@Transactional
	public Tarefa insert(Tarefa obj, Integer destinatarioId, Integer remetenteId) throws ParseException {
		obj.setId(null);
		
		usuarioService.findById(remetenteId);
		
		Tarefa newTarefa = repo.save(obj);
		
		String conteudo = "criou uma nova tarefa.";
		Date instante = sdf2.parse(sdf2.format(new Date()));
		
		Notificacao not = new Notificacao(null, conteudo, "", false, remetenteId, destinatarioId, newTarefa.getId(), instante);
		notificacaoService.insert(not);
		
		return newTarefa;
	}
	
	/**
	 * Metodo responsável por retornar uma Lista de Tarefas do banco de dados em forma de paginas
	 * 
	 * @param page
	 * @param linePerPage
	 * @param direction
	 * @param orderBy
	 * @return Page<Tarefa>
	 */
	public Page<Tarefa> findPage(Integer page, Integer linePerPage, String direction, String orderBy){
		PageRequest obj = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(obj);
	}
	
	
	public List<Tarefa> findByUsuario(Integer usuarioId){
		usuarioService.findById(usuarioId);
		List<Tarefa> tarefas = repo.findByUsuario(usuarioId);
		
		return tarefas;
	}
	
	//Methods aux
	public Tarefa fromDTO(TarefaUpdateDTO objDto) {
		Date concluido = null;
		Date dataPrazo = null;
		try {
			if(objDto.getConcluido() != null) {
				concluido = sdf2.parse(objDto.getConcluido());	
			}
			if(objDto.getDataPrazo() != null) {
				dataPrazo = sdf.parse(objDto.getDataPrazo());
			}
		}catch(ParseException e) {
			throw new ParseDateException("Erro ao converter valores");
		}
		
		Tarefa obj = new Tarefa(objDto.getId(), objDto.getTitulo(), objDto.getConteudo(), objDto.getAnexoChefe(),
				objDto.getAnexoFuncionario(), null, dataPrazo, objDto.getPrioridade(), concluido);
		
		return obj;
	}
	
	public Tarefa fromDTO(TarefaNewDTO objDto) {
		Date dataPrazo = null;
		try {
			if(objDto.getDataPrazo() != null) {
				dataPrazo = sdf.parse(objDto.getDataPrazo());
			}
		}catch(ParseException e) {
			throw new ParseDateException("Erro ao converter valores");
		}
		
		Tarefa obj = new Tarefa(null, objDto.getTitulo(),
				objDto.getConteudo(), objDto.getAnexoChefe(), objDto.getAnexoFuncionario(), new Date(), dataPrazo,
				objDto.getPrioridade(), null);
		
		Usuario chefe = usuarioService.findById(objDto.getChefe());
		Usuario funcionario = usuarioService.findById(objDto.getFuncionario());
		
		obj.getUsuario().addAll(Arrays.asList(chefe, funcionario));
		
		chefe.getTarefas().add(obj);
		funcionario.getTarefas().add(obj);
		
		return obj;
	}
	
	public void updateData(Tarefa obj, Tarefa newObj) {
		if(obj.getTitulo() != null) {
			newObj.setTitulo(obj.getTitulo());
		}
		if(obj.getConteudo() != null) {
			newObj.setConteudo(obj.getConteudo());
		}
		if(obj.getAnexoChefe() != null) {
			newObj.setAnexoChefe(obj.getAnexoChefe());
		}
		if(obj.getAnexoFuncionario() != null) {
			newObj.setAnexoFuncionario(obj.getAnexoFuncionario());
		}
		if(obj.getDataPrazo() != null) {
			newObj.setDataPrazo(obj.getDataPrazo());
		}
		if(obj.getPrioridade() != null) {
			newObj.setPrioridade(obj.getPrioridade());
		}
		if(obj.getConcluido() != null) {
			newObj.setConcluido(obj.getConcluido());
		}
	}
}
