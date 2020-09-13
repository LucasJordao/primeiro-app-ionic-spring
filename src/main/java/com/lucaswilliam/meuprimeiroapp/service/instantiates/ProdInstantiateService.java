package com.lucaswilliam.meuprimeiroapp.service.instantiates;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.domains.Cidade;
import com.lucaswilliam.meuprimeiroapp.domains.Endereco;
import com.lucaswilliam.meuprimeiroapp.domains.Organizacao;
import com.lucaswilliam.meuprimeiroapp.domains.Telefone;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoCargo;
import com.lucaswilliam.meuprimeiroapp.repositories.CidadeRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.OrganizacaoRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.UsuarioRepository;

@Service
public class ProdInstantiateService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private OrganizacaoRepository organizacaoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	public void instantiate() {
		
		Usuario user = new Usuario(null, "Lucas William Silva Jorão", "lucaswill12@hotmail.com", bcrypt.encode("123"), null, true);
		
		Usuario u3 = new Usuario(null, "Lucas William Silva Jordão", "lucasw@hotmail.com", bcrypt.encode("123"), null, true);
		u3.addAuthorities(TipoCargo.CHEFE);
		
		Organizacao o1 = new Organizacao(null, "Catrix", null, "Empresa de softwares");
		user.getOrganizacoes().add(o1);
		o1.getUsuarios().add(user);
		Telefone tel1 = new Telefone(null, 83, "986679667", user, null);
		user.getTelefones().add(tel1);
		Optional<Cidade> cid1 = cidadeRepository.findById(1294);
		Endereco e1 = new Endereco(null, "Sabará", "58421760", "Rua", "30","Cidades", user, cid1.get() ,null);
		
		user.getEnderecosUsuario().add(e1);
		
		organizacaoRepository.save(o1);
		usuarioRepository.saveAll(Arrays.asList(user));
	}
	
}
