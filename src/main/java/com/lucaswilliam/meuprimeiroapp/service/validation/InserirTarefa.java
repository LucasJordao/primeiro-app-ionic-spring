package com.lucaswilliam.meuprimeiroapp.service.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lucaswilliam.meuprimeiroapp.service.validation.constraints.TarefaValidator;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TarefaValidator.class)
public @interface InserirTarefa {

	String message() default "Erro de validação";
	
	Class<?> [] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	String value() default "";
	
}
