package com.lucaswilliam.meuprimeiroapp.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucaswilliam.meuprimeiroapp.service.instantiates.DevInstantiateService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DevInstantiateService dev;
	
	@Bean
	public boolean instantiate() throws ParseException {
		
		dev.instantiate();
		
		return true;
	}
	
}
