package com.lucaswilliam.meuprimeiroapp.service.instantiates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.domains.Organizacao;
import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;
import com.lucaswilliam.meuprimeiroapp.domains.Telefone;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoCargo;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoPrioridade;
import com.lucaswilliam.meuprimeiroapp.repositories.OrganizacaoRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.TarefaRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.TelefoneRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.UsuarioRepository;

@Service
public class DevInstantiateService {
	// Repositories
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private OrganizacaoRepository organizacaoRepository;

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	public void instantiate() throws ParseException {
		// Instanciando Usuario, Organização e Telefone
		Usuario u1 = new Usuario(null, "Lucas William", "Lucas@hotmail.com", bcrypt.encode("12345678"), null, true);
		Usuario u2 = new Usuario(null, "Marcos Santos", "marcos@hotmail.com", bcrypt.encode("12345678"), null, true);
		
		
		Usuario u3 = new Usuario(null, "Lucas William Silva Jordão", "lucasw@hotmail.com", bcrypt.encode("12345678"), null, true);
		Usuario u4 = new Usuario(null, "Marcos Santos", "marcos23@hotmail.com", bcrypt.encode("12345678"), null, true);
		u4.addAuthorities(TipoCargo.CHEFE);
		u3.addAuthorities(TipoCargo.CHEFE);

		Organizacao o1 = new Organizacao(null, "Energisa", null, "Trazendo energia desde 1989");
		Organizacao o2 = new Organizacao(null, "LG", null, "Fazendo sua imagem melhor");
		Organizacao o3 = new Organizacao(null, "Semp", null, "Qualidade de ponta");

		Telefone tel1 = new Telefone(null, 83, "88174566", u1, null);
		Telefone tel2 = new Telefone(null, 83, "40028922", u2, null);
		Telefone tel3 = new Telefone(null, 83, "86489658", u1, null);
		Telefone tel4 = new Telefone(null, 82, "33334582", null, o1);

		u1.getOrganizacoes().addAll(Arrays.asList(o1));
		u2.getOrganizacoes().addAll(Arrays.asList(o1));
		u4.getOrganizacoes().addAll(Arrays.asList(o1));

		o1.getUsuarios().addAll(Arrays.asList(u1, u2, u4));

		u1.getTelefones().addAll(Arrays.asList(tel1, tel3));
		u2.getTelefones().addAll(Arrays.asList(tel2));
		o1.getTelefonesOrganizacao().addAll(Arrays.asList(tel4));

		organizacaoRepository.saveAll(Arrays.asList(o1, o2, o3));
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u4, u3));
		telefoneRepository.saveAll(Arrays.asList(tel1, tel2, tel3, tel4));

		// Instanciando Cidade, Estado e Endereco

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Tarefa t1 = new Tarefa(null, "Corrigir Domain Cliente", "Por favor verificar exceções", null, null, new Date(),
				sdf.parse("11/10/2020"), TipoPrioridade.NORMAL, null);
		t1.getUsuario().addAll(Arrays.asList(u1, u2));
		u1.getTarefas().addAll(Arrays.asList(t1));
		u2.getTarefas().addAll(Arrays.asList(t1));

		organizacaoRepository.saveAll(Arrays.asList(o1));
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		tarefaRepository.saveAll(Arrays.asList(t1));
	}
}
