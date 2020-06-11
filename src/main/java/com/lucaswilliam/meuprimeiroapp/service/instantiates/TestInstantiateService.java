package com.lucaswilliam.meuprimeiroapp.service.instantiates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaswilliam.meuprimeiroapp.domains.Cidade;
import com.lucaswilliam.meuprimeiroapp.domains.Endereco;
import com.lucaswilliam.meuprimeiroapp.domains.Organizacao;
import com.lucaswilliam.meuprimeiroapp.domains.Tarefa;
import com.lucaswilliam.meuprimeiroapp.domains.Telefone;
import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoCargo;
import com.lucaswilliam.meuprimeiroapp.domains.enums.TipoPrioridade;
import com.lucaswilliam.meuprimeiroapp.repositories.CidadeRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.EnderecoRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.OrganizacaoRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.TarefaRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.TelefoneRepository;
import com.lucaswilliam.meuprimeiroapp.repositories.UsuarioRepository;

@Service
public class TestInstantiateService {
	// Repositories
		@Autowired
		private UsuarioRepository usuarioRepository;

		@Autowired
		private TelefoneRepository telefoneRepository;

		@Autowired
		private OrganizacaoRepository organizacaoRepository;

		@Autowired
		private CidadeRepository cidadeRepository;

		@Autowired
		private EnderecoRepository enderecoRepository;

		@Autowired
		private TarefaRepository tarefaRepository;

		public void instantiate() throws ParseException {
			// Instanciando Usuario, Organização e Telefone
			Usuario u1 = new Usuario(null, "Lucas William", "Lucas@hotmail.com", "123", TipoCargo.CHEFE, null, true);
			Usuario u2 = new Usuario(null, "Marcos Santos", "marcos@hotmail.com", "123", TipoCargo.FUNCIONARIO, null, true);

			Organizacao o1 = new Organizacao(null, "Energisa", null, "Trazendo energia desde 1989");
			Organizacao o2 = new Organizacao(null, "LG", null, "Fazendo sua imagem melhor");
			Organizacao o3 = new Organizacao(null, "Semp", null, "Qualidade de ponta");

			Telefone tel1 = new Telefone(null, 83, "88174566", u1, null);
			Telefone tel2 = new Telefone(null, 83, "40028922", u2, null);
			Telefone tel3 = new Telefone(null, 83, "86489658", u1, null);
			Telefone tel4 = new Telefone(null, 82, "33334582", null, o1);

			u1.getOrganizacoes().addAll(Arrays.asList(o1));
			u2.getOrganizacoes().addAll(Arrays.asList(o1));

			o1.getUsuarios().addAll(Arrays.asList(u1, u2));

			u1.getTelefones().addAll(Arrays.asList(tel1, tel3));
			u2.getTelefones().addAll(Arrays.asList(tel2));
			o1.getTelefonesOrganizacao().addAll(Arrays.asList(tel4));

			organizacaoRepository.saveAll(Arrays.asList(o1, o2, o3));
			usuarioRepository.saveAll(Arrays.asList(u1, u2));
			telefoneRepository.saveAll(Arrays.asList(tel1, tel2, tel3, tel4));

			// Instanciando Cidade, Estado e Endereco

			Optional<Cidade> cid1 = cidadeRepository.findById(1);
			Optional<Cidade> cid2 = cidadeRepository.findById(2);
			Optional<Cidade> cid3 = cidadeRepository.findById(3);

			Endereco end1 = new Endereco(null, "Sabará", "4892653", "Rua", "30", "Cidades", u1, cid1.get(), null);
			Endereco end2 = new Endereco(null, "Comerciante Alfredo Ferreira da Rocha", "58055000", "Rua", "40",
					"Mangabeira", u2, cid2.get(), null);
			Endereco end3 = new Endereco(null, "Pedro Gama", "57320000", "Rua", "100", "Centro", null, cid3.get(), o1);

			u1.getEnderecosUsuario().addAll(Arrays.asList(end1));
			u2.getEnderecosUsuario().addAll(Arrays.asList(end2));
			o1.getEnderecos().addAll(Arrays.asList(end3));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			Tarefa t1 = new Tarefa(null, "Corrigir Domain Cliente", "Por favor verificar exceções", null, null, new Date(),
					sdf.parse("11/10/2020"), TipoPrioridade.NORMAL, null);
			t1.getUsuario().addAll(Arrays.asList(u1, u2));
			u1.getTarefas().addAll(Arrays.asList(t1));
			u2.getTarefas().addAll(Arrays.asList(t1));

			
			enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
			organizacaoRepository.saveAll(Arrays.asList(o1));
			usuarioRepository.saveAll(Arrays.asList(u1, u2));
			tarefaRepository.saveAll(Arrays.asList(t1));
		}
}
