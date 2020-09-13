package com.lucaswilliam.meuprimeiroapp.service.validation.constraints;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.lucaswilliam.meuprimeiroapp.domains.Usuario;
import com.lucaswilliam.meuprimeiroapp.domains.dto.UsuarioDTO;
import com.lucaswilliam.meuprimeiroapp.repositories.UsuarioRepository;
import com.lucaswilliam.meuprimeiroapp.resources.exceptions.FieldMessage;
import com.lucaswilliam.meuprimeiroapp.service.validation.UpdateUsuario;

public class UsuarioUpdateValidator implements ConstraintValidator<UpdateUsuario, UsuarioDTO> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private UsuarioRepository repository;

	@Override
	public void initialize(UpdateUsuario ann) {
	}

	@Override
	public boolean isValid(UsuarioDTO value, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

		List<FieldMessage> list = new ArrayList<>();

		Integer mapId = Integer.parseInt(map.get("id"));

		Usuario user = repository.findByEmail(value.getEmail());

		if (user != null && !user.getId().equals(mapId)) {
			list.add(new FieldMessage("email", "Email já em uso"));
		}

		if(user != null && value.getEmail().toLowerCase().equals(user.getEmail().toLowerCase())) {
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
