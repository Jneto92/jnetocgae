package com.jneto.cgae.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jneto.cgae.entities.Publico;
import com.jneto.cgae.repositories.PublicoRepository;
import com.jneto.cgae.services.exceptions.ResourceNotFoundException;

@Service
public class PublicoService {
	@Autowired
	private PublicoRepository repository;
	
	public List<Publico> findAll(){
		return repository.findAll();
	}
	
	public Publico findById(Long id) {
		Optional<Publico> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Publico insert(Publico obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Publico update(Long id, Publico obj) {
		@SuppressWarnings("deprecation")
		Publico entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Publico entity, Publico obj) {
		// TODO Auto-generated method stub
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
}
