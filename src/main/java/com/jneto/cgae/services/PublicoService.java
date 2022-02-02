package com.jneto.cgae.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jneto.cgae.entities.Publico;
import com.jneto.cgae.repositories.PublicoRepository;

@Service
public class PublicoService {
	@Autowired
	private PublicoRepository repository;
	
	public List<Publico> findAll(){
		return repository.findAll();
	}
	
	public Publico findById(Long id) {
		Optional<Publico> obj = repository.findById(id);
		
		return obj.get();
	}
	
	public Publico insert(Publico obj) {
		return repository.save(obj);
	}
	
}
