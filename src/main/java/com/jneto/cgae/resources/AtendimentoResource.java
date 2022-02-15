package com.jneto.cgae.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jneto.cgae.entities.Atendimento;
import com.jneto.cgae.entities.Categoria;
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
	
	@GetMapping(value = "/categoria/{cat}")
	public ResponseEntity<List<Atendimento>> findByCategoria(@PathVariable Categoria cat){
		List<Atendimento> list = service.findByCategoria(cat);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Atendimento> findById(@PathVariable Long id){
		Atendimento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Atendimento> insert(@RequestBody Atendimento obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Atendimento> update(@PathVariable Long id, @RequestBody Atendimento obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
