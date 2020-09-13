package com.lucaswilliam.meuprimeiroapp.service.utils;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.slf4j.LoggerFactory;

public class SmtpEmailService extends AbstractEmailService{

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendMail(SimpleMailMessage msg) {
		LOG.info("Enviando o email...");
		mailSender.send(msg);
		LOG.info("Email enviado!");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Enviando o email html...");
		javaMailSender.send(msg);
		LOG.info("Email enviado!");
		
	}

}
