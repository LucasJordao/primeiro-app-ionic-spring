package com.lucaswilliam.meuprimeiroapp.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucaswilliam.meuprimeiroapp.service.instantiates.ProdInstantiateService;

@Configuration
@Profile("prod")
public class ProdConfig {
	
	@Autowired
	private ProdInstantiateService prod;
	
	@Bean
	public boolean instantiate() throws ParseException {
		
		prod.instantiate();
		
		return true;
	}
	
}
