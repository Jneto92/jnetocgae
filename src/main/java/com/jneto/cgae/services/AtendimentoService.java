package com.jneto.cgae.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jneto.cgae.entities.Atendimento;
import com.jneto.cgae.repositories.AtendimentoRepository;

@Service
public class AtendimentoService {
	@Autowired
	private AtendimentoRepository repository;
	
	public List<Atendimento> findAll(){
		return repository.findAll();
	}
	
	public Atendimento findById(Long id) {
		Optional<Atendimento> obj = repository.findById(id);
		
		return obj.get();
	}
	public Atendimento insert (Atendimento obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Atendimento update(Long id, Atendimento obj) {
		@SuppressWarnings("deprecation")
		Atendimento entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
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
