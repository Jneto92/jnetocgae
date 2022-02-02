package com.jneto.cgae.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jneto.cgae.entities.Atendimento;
import com.jneto.cgae.services.AtendimentoService;

@RestController
@RequestMapping(value = "/atendimento")
public class AtendimentoResource {
	@Autowired
	private AtendimentoService service;
	
	@GetMapping
	public ResponseEntity<List<Atendimento>> findAll(){
		List<Atendimento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Atendimento> findById(@PathVariable Long id){
		Atendimento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
