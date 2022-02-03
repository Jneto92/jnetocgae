package com.jneto.cgae.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jneto.cgae.entities.Funcionario;
import com.jneto.cgae.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository repository;
	
	public List<Funcionario> findAll(){
		return repository.findAll();
	}
	
	public Funcionario findById(Long id) {
		Optional<Funcionario> obj = repository.findById(id);
		
		return obj.get();
	}
	
	public Funcionario insert(Funcionario obj) {
		return repository.save(obj);
	}
	
}
