package com.lucaswilliam.meuprimeiroapp.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucaswilliam.meuprimeiroapp.service.instantiates.TestInstantiateService;

@Configuration
@Profile("test")
public class TestConfig{
	
	@Autowired
	private TestInstantiateService test;
	
	@Bean
	public boolean intantiate() throws ParseException {
		test.instantiate();
		return true;
	}

}
