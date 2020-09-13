package com.lucaswilliam.meuprimeiroapp.service.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;

import com.lucaswilliam.meuprimeiroapp.domains.Usuario;

public interface EmailService {
	
	@Async("fileExecutor")
	void sendCountConfirmationEmail(Usuario usuario);
	
	void sendMail(SimpleMailMessage msg);
	
	@Async("fileExecutor")
	void sendCountConfirmationHtmlEmail(Usuario usuario);
	
	void sendHtmlEmail(MimeMessage mm);
}
