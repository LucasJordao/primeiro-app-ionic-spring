package com.lucaswilliam.meuprimeiroapp.service.validation.constraints;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.dto.UsuarioNewDTO;
import com.lucaswilliam.meuprimeiroapp.repositories.UsuarioRepository;
import com.lucaswilliam.meuprimeiroapp.resources.exceptions.FieldMessage;
import com.lucaswilliam.meuprimeiroapp.service.validation.InsertUsuario;

public class UsuarioValidator implements ConstraintValidator<InsertUsuario, UsuarioNewDTO>{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void initialize(InsertUsuario ann) {
	}
	
	@Override
	public boolean isValid(UsuarioNewDTO value, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		Usuario user = repository.findByEmail(value.getEmail());
		
		if(user != null && value.getEmail().equals(user.getEmail())) {
			list.add(new FieldMessage("email", "Email já em uso"));
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
	
	
}
