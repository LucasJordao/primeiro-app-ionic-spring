package com.lucaswilliam.meuprimeiroapp.service.validation.constraints;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lucaswilliam.meuprimeiroapp.domains.dto.TarefaNewDTO;
import com.lucaswilliam.meuprimeiroapp.resources.exceptions.FieldMessage;
import com.lucaswilliam.meuprimeiroapp.service.validation.InserirTarefa;

public class TarefaValidator implements ConstraintValidator<InserirTarefa, TarefaNewDTO>{
	
	@Override
	public void initialize(InserirTarefa ann) {
	}
	
	@Override
	public boolean isValid(TarefaNewDTO value, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(value.getChefe() == value.getFuncionario()) {
			list.add(new FieldMessage("funcionario", "O destinatário da tarefa não pode ser você mesmo."));
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
	
	
}
