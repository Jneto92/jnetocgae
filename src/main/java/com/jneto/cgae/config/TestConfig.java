package com.jneto.cgae.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jneto.cgae.entities.Publico;
import com.jneto.cgae.repositories.PublicoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private PublicoRepository publicoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Publico u1 = new Publico(null, "Maria Brown", "maria@gmail.com", "988888888");
		Publico u2 = new Publico(null, "Alex Green", "alex@gmail.com", "977777777");
		
		publicoRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
}
