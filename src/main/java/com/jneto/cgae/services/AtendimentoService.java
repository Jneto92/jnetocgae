package com.jneto.cgae.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jneto.cgae.entities.Atendimento;
import com.jneto.cgae.entities.Categoria;
import com.jneto.cgae.repositories.AtendimentoRepository;
import com.jneto.cgae.services.exceptions.DatabaseException;
import com.jneto.cgae.services.exceptions.ResourceNotFoundException;

@Service
public class AtendimentoService {
	@Autowired
	private AtendimentoRepository repository;
	
	public List<Atendimento> findAll(){
		return repository.findAll();
	}
	
	public List<Atendimento> findByCategoria(Categoria cat){
		List<Atendimento> obj = repository.findByCategoria(cat);
		if (obj == null) {
			throw new ResourceNotFoundException(cat);
		}else {
			return obj;
		}
		
			
	}
	
	public Atendimento findById(Long id) {
		Optional<Atendimento> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Atendimento insert (Atendimento obj) {
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
	
	public Atendimento update(Long id, Atendimento obj) {
		try {
			@SuppressWarnings("deprecation")
			Atendimento entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Atendimento entity, Atendimento obj) {
		// TODO Auto-generated method stub
		entity.setMomentAtendimento(obj.getMomentAtendimento());
		entity.setMomentSolicitacao(obj.getMomentSolicitacao());
		entity.setMomentEncerramento(obj.getMomentEncerramento());
		entity.setAtendimentoStatus(obj.getAtendimentoStatus());
		entity.setAtendente(obj.getAtendente());
		entity.setCategoria(obj.getCategoria());
		entity.setSolicitante(obj.getSolicitante());
	}
}
