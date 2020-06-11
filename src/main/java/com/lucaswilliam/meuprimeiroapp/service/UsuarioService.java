package com.lucaswilliam.meuprimeiroapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucaswilliam.meuprimeiroapp.domains.Cidade;
import com.lucaswilliam.meuprimeiroapp.domains.Endereco;
import com.lucaswilliam.meuprimeiroapp.domains.Organizacao;
import com.lucaswilliam.meuprimeiroapp.domains.Telefone;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.dto.UsuarioDTO;
import com.lucaswilliam.meuprimeiroapp.domains.dto.UsuarioNewDTO;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoCargo;
import com.lucaswilliam.meuprimeiroapp.repositories.EnderecoRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.OrganizacaoRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.TelefoneRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.UsuarioRepository;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.DataIntegrityException;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	// Repositories
	@Autowired
	private UsuarioRepository repo;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private OrganizacaoRepository organizacaoRepository;

	/**
	 * Metodo responsável por recuperar uma lista de usuarios do banco de dados
	 * 
	 * @return Lista de objetos do tipo Usuario
	 */
	public List<Usuario> findAll() {
		return repo.findAll();
	}

	/**
	 * Metodo responsável por recuperar um usuario do banco de dados
	 * 
	 * @param id
	 * @exception ObjectNotFoundException
	 * @return objeto do tipo Usuario
	 */
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Usuário não encontrado. Id:" + id + ", Tipo: " + Usuario.class.getTypeName()));
	}

	/**
	 * Metodo responsável por atualizar usuario do banco de dados por meio do id
	 * @param obj
	 * @return void
	 */
	public void update(Usuario obj) {
		Usuario newObj = this.findById(obj.getId());
		updateData(obj, newObj);
		repo.save(newObj);
	}

	/**
	 * Metodo responsável por retornar um lista de usuarios do banco de dados em
	 * paginas
	 * 
	 * @return Page<Usuario>
	 * @param page
	 * @param linePerPage
	 * @param direction
	 * @param orderBy
	 */
	public Page<Usuario> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}
	
	/**
	 * Metodo responsavel por deletar usuario apartir do id
	 * @param id
	 * @return void
	 */
	public void delete(Integer id) {
		this.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Você não pode deletar esse usuário, pois ele tem uma tarefa associada");
		}
	}/**
	 * Metodo responsável por inserir usuario no banco de dados
	 * @param obj
	 * @return Objeto do tipo Usuario
	 */
	@Transactional()
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		List<Telefone> telefones = obj.getTelefones();
		List<Endereco> end = obj.getEnderecosUsuario();
		
		Usuario user = repo.save(obj);
		enderecoRepository.saveAll(end);
		telefoneRepository.saveAll(telefones);
		return user;
	}

	public List<Usuario> search(String nome){
		List<Usuario> list = repo.search(nome);
		
		return list;
	}
	
	public List<Usuario> searchFuncionario(String nome){
		List<Usuario> list = repo.searchFuncionario(nome);
		
		return list;
	}
	
	// Methods aux
	private static void updateData(Usuario obj, Usuario newObj) {
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}
		if (obj.getEmail() != null) {
			newObj.setEmail(obj.getEmail());
		}
		if (obj.getSenha() != null) {
			newObj.setSenha(obj.getSenha());
		}
		if (obj.getCargo() != null) {
			newObj.setCargo(obj.getCargo());
		}
		if (obj.getFotoPerfil() != null) {
			newObj.setFotoPerfil(obj.getFotoPerfil());
		}
		obj.setPrimeiroAcesso(false);
	}

	public Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), objDTO.getSenha(),
				TipoCargo.toEnum(objDTO.getCargo()), null, objDTO.getPrimeiroAcesso());
	}

	/**
	 * Metodo responsavel por converter um UsuarioNewDto para um Usuario
	 * @param objDTO
	 * @return Objeto do tipo Usuario
	 */
	public Usuario fromNewDTO(UsuarioNewDTO objDTO) {
		Usuario user = new Usuario(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getSenha(), objDTO.getCargo(),
				objDTO.getFotoPerfil(), true);
		Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getCep(), objDTO.getComplemento(), objDTO.getNumero(), objDTO.getBairro(), user, new Cidade(objDTO.getCidadeId(), null,null), null);
		
		Optional<Organizacao> org1 = organizacaoRepository.findById(objDTO.getOrganizacaoId());
		Organizacao o1 = org1.get();
		
		user.getOrganizacoes().add(o1);
		
		o1.getUsuarios().add(user);
		
		Telefone tel1 = objDTO.getTelefone1();
		tel1.setUsuario(user);
		user.getTelefones().add(tel1);
		
		if(objDTO.getTelefone2() != null) {
			Telefone tel2 = objDTO.getTelefone2();
			tel2.setUsuario(user);
			user.getTelefones().add(tel2);
		}
		if(objDTO.getTelefone3() != null) {
			Telefone tel3 = objDTO.getTelefone3();
			tel3.setUsuario(user);
			user.getTelefones().add(tel3);
		}
		
		user.getEnderecosUsuario().add(end);
		
		return user;
	}
}
