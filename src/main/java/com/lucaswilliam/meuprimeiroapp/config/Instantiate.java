package com.lucaswilliam.meuprimeiroapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucaswilliam.meuprimeiroapp.domains.Cidade;
import com.lucaswilliam.meuprimeiroapp.domains.Endereco;
import com.lucaswilliam.meuprimeiroapp.domains.Estado;
import com.lucaswilliam.meuprimeiroapp.domains.Organizacao;
import com.lucaswilliam.meuprimeiroapp.domains.Telefone;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoCargo;
import com.lucaswilliam.meuprimeiroapp.repositories.CidadeRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.EnderecoRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.EstadoRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.OrganizacaoRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.TelefoneRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.UsuarioRepository;

@Configuration
public class Instantiate implements CommandLineRunner{

	//Repositories
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private OrganizacaoRepository organizacaoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//Instanciando Usuario, Organização e Telefone
		Usuario u1 = new Usuario(null, "Lucas William", "Lucas@hotmail.com", "123", TipoCargo.CHEFE, null);
		Usuario u2 = new Usuario(null, "Marcos Santos", "marcos@hotmail.com", "123", TipoCargo.FUNCIONARIO, null);
		
		Organizacao o1 = new Organizacao(null, "Energisa", null, "Trazendo energia desde 1989");
		
		Telefone tel1 = new Telefone(null, 83, "88174566", u1, null);
		Telefone tel2 = new Telefone(null, 83, "40028922", u2, null);
		Telefone tel3 = new Telefone(null, 83, "86489658", u1, null);
		Telefone tel4 = new Telefone(null, 82, "33334582", null, o1);
		
		u1.getOrganizacao().addAll(Arrays.asList(o1));
		u2.getOrganizacao().addAll(Arrays.asList(o1));
		
		u1.getTelefones().addAll(Arrays.asList(tel1, tel3));
		u2.getTelefones().addAll(Arrays.asList(tel2));
		o1.getTelefonesOrganizacao().addAll(Arrays.asList(tel4));
		
		o1.getUsuarios().addAll(Arrays.asList(u1, u2));
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		organizacaoRepository.saveAll(Arrays.asList(o1));
		telefoneRepository.saveAll(Arrays.asList(tel1, tel2, tel3, tel4));
		
		//Instanciando Cidade, Estado e Endereco
		
		Estado est1 = new Estado(null, "Paraíba");
		Estado est2 = new Estado(null, "Alagoas");
		
		Cidade cid1 = new Cidade(null, "Campina Grande", est1);
		Cidade cid2 = new Cidade(null, "João Pessoa", est1);
		Cidade cid3 = new Cidade(null, "Craibas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		Endereco end1 = new Endereco(null, "Sabará", "4892653", "Rua", "30", "Cidades", u1, cid1, null);
		Endereco end2 = new Endereco(null, "Comerciante Alfredo Ferreira da Rocha", "58055000", "Rua", "40", "Mangabeira", u2, cid2, null);
		Endereco end3 = new Endereco(null, "Pedro Gama", "57320000", "Rua", "100", "Centro", null, cid3, o1);
		
		u1.getEnderecosUsuario().addAll(Arrays.asList(end1));
		u2.getEnderecosUsuario().addAll(Arrays.asList(end2));
		o1.getEnderecos().addAll(Arrays.asList(end3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		organizacaoRepository.saveAll(Arrays.asList(o1));
	}

}
