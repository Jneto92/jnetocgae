package com.jneto.cgae.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jneto.cgae.entities.Atendimento;
import com.jneto.cgae.entities.Publico;
import com.jneto.cgae.entities.enums.AtendimentoStatus;
import com.jneto.cgae.repositories.AtendimentoRepository;
import com.jneto.cgae.repositories.PublicoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private PublicoRepository publicoRepository;

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Publico u1 = new Publico(null, "Maria Brown", "maria@gmail.com", "988888888");
		Publico u2 = new Publico(null, "Alex Green", "alex@gmail.com", "977777777");
		
		Atendimento o1 = new Atendimento(null, Instant.parse("2019-06-20T19:53:07Z"), AtendimentoStatus.WAITING, u1);
		Atendimento o2 = new Atendimento(null, Instant.parse("2019-07-21T03:42:10Z"), AtendimentoStatus.WAITING, u2);
		Atendimento o3 = new Atendimento(null, Instant.parse("2019-07-22T15:21:22Z"), AtendimentoStatus.WAITING, u1); 
		
		publicoRepository.saveAll(Arrays.asList(u1, u2));
		atendimentoRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	
}
