package com.lucaswilliam.meuprimeiroapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.documents.Notificacao;
import com.lucaswilliam.meuprimeiroapp.domains.dto.NotificacaoDTO;
import com.lucaswilliam.meuprimeiroapp.domains.dto.UsuarioDTO;
import com.lucaswilliam.meuprimeiroapp.repositories.NotificacaoRepository;

@Service
public class NotificacaoService {
	
	@Autowired
	private NotificacaoRepository repo;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Async("fileExecutor")
	public void insert(Notificacao not) {
		repo.save(not);
	}
	
	public List<Notificacao> findByDestinatario(Integer id){
		return repo.findByDestinatario(id);
	}
	
	public NotificacaoDTO fromDTO(Notificacao not) {
		UsuarioDTO remetente = new UsuarioDTO(usuarioService.findById(not.getRemetente()));
		UsuarioDTO destinatario = new UsuarioDTO(usuarioService.findById(not.getDestinatario()));
		NotificacaoDTO objDTO = new NotificacaoDTO(not.getTarefa(), remetente, destinatario, not.getVisualizado(), not.getInstante(), not.getConteudo(), not.getDescricao());
		
		return objDTO;
	}
}
