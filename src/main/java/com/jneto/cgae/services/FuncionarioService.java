package com.jneto.cgae.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jneto.cgae.entities.Funcionario;
import com.jneto.cgae.repositories.FuncionarioRepository;
import com.jneto.cgae.services.exceptions.DatabaseException;
import com.jneto.cgae.services.exceptions.ResourceNotFoundException;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository repository;
	
	public List<Funcionario> findAll(){
		return repository.findAll();
	}
	
	public Funcionario findById(Long id) {
		Optional<Funcionario> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Funcionario insert(Funcionario obj) {
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
	
	public Funcionario update(Long id, Funcionario obj) {
		try {
			@SuppressWarnings("deprecation")
			Funcionario entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Funcionario entity, Funcionario obj) {
		// TODO Auto-generated method stub
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		entity.setFuncao(obj.getFuncao());
		entity.setMatricula(obj.getMatricula());
		entity.setSetor(obj.getSetor());
	}
}
