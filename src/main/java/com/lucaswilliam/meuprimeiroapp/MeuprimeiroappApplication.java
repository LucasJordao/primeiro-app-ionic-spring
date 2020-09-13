package com.lucaswilliam.meuprimeiroapp;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class MeuprimeiroappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuprimeiroappApplication.class, args);
	}
	
	@Bean(name = "fileExecutor")
	public Executor asyncExecutor() {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(3);
		executor.initialize();
		return executor;
	}

}
