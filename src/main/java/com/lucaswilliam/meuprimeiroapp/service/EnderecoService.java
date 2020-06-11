package com.lucaswilliam.meuprimeiroapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucaswilliam.meuprimeiroapp.domains.Cidade;
import com.lucaswilliam.meuprimeiroapp.domains.Endereco;
import com.lucaswilliam.meuprimeiroapp.domains.Organizacao;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.dto.EnderecoNewDTO;
import com.lucaswilliam.meuprimeiroapp.repositories.EnderecoRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.OrganizacaoRepository;

@Service
public class EnderecoService {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private OrganizacaoRepository orgRepository;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private EnderecoRepository repo;
	
	public Endereco insert(Endereco end) {
		Endereco obj =  repo.save(end);
		
		return obj;
	}
	
	
	//Methods aux
	@Transactional
	public Endereco fromDTO(EnderecoNewDTO obj) {
		
		Usuario usuario = null;
		Organizacao org = null;
		
		if(obj.getUsuarioId() != null) {
			usuario = usuarioService.findById(obj.getUsuarioId());
		}
		if(obj.getOrganizacaoId() != null) {
			Optional<Organizacao> objOrg = orgRepository.findById(obj.getOrganizacaoId());
			org = objOrg.get();
		}
		
		Cidade cid = cidadeService.findById(obj.getCidadeId());
		
		Endereco end = new Endereco(null, obj.getLogradouro(), obj.getCep(), obj.getComplemento(), obj.getBairro(), obj.getBairro(),
				usuario, cid, org);
		
		if(obj.getUsuarioId() != null) {
			usuario.getEnderecosUsuario().add(end);
		}
		if(obj.getOrganizacaoId() != null) {
			org.getEnderecos().add(end);
		}
		
		return end;
	}
}
