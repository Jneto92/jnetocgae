package com.jneto.cgae.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jneto.cgae.entities.Categoria;
import com.jneto.cgae.repositories.CategoriaRepository;
import com.jneto.cgae.services.exceptions.DatabaseException;
import com.jneto.cgae.services.exceptions.ResourceNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Categoria insert(Categoria obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
			}catch (EmptyResultDataAccessException e) {
				throw new ResourceNotFoundException(id);
			} catch (DataIntegrityViolationException e) {
				throw new DatabaseException(e.getMessage());
			}
	}
	
	public Categoria update(Long id, Categoria obj) {
		@SuppressWarnings("deprecation")
		Categoria entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Categoria entity, Categoria obj) {
		// TODO Auto-generated method stub
		entity.setNome(obj.getNome());
	}
}
