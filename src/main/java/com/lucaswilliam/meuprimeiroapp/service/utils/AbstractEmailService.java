package com.lucaswilliam.meuprimeiroapp.service.utils;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.service.exceptions.EmailException;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendCountConfirmationEmail(Usuario obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);

		sendMail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Usuario obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Bem Vindo, " + obj.getNome());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Olá, " + obj.getNome() + ", seja bem-vindo a Catrix!");
		
		return sm;
	}
	
	protected String htmlFromTemplatePedido(Usuario usuario) {
		Context context = new Context();
		String[] nomes = usuario.getNome().split(" ");
		String nome = nomes[0] + " " + nomes[1];
		usuario.setNome(nome);
		context.setVariable("usuario", usuario);
		return templateEngine.process("email/confirmacaoFuncionario", context);
	}

	@Override
	public void sendCountConfirmationHtmlEmail(Usuario obj) {
		try {
			MimeMessage mm = prepareMimeMessageFromPedido(obj);
			sendHtmlEmail(mm);
		}catch(MessagingException e) {
			sendCountConfirmationEmail(obj);
		}catch(Exception e) {
			throw new EmailException(e.getMessage());
		}
	}
	
	
	protected MimeMessage prepareMimeMessageFromPedido(Usuario obj) throws MessagingException {
		MimeMessage mm = javaMailSender.createMimeMessage();
		MimeMessageHelper mh = new MimeMessageHelper(mm, true);
		mh.setTo(obj.getEmail());
		mh.setFrom(sender);
		mh.setSubject("Email de boas vindas");
		mh.setSentDate(new Date(System.currentTimeMillis()));
		mh.setText(this.htmlFromTemplatePedido(obj), true);
		return mm;
	}
}
